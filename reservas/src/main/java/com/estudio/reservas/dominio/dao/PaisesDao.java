package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PaisesDao implements PaisesDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Paises pais) throws DaoException {
        String sql = "INSERT INTO paises (nombre, usuario_modificado, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    pais.getNombre(),
                    pais.getUsuario_modificado() != null ? pais.getUsuario_modificado() : "defaultUser",
                    pais.getCreated_at() != null ? Timestamp.valueOf(pais.getCreated_at()) : new Timestamp(System.currentTimeMillis()),
                    pais.getUpdated_at() != null ? Timestamp.valueOf(pais.getUpdated_at()) : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar país: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar país", e);
        }
    }

    @Override
    public void update(Paises pais) throws DaoException {
        String sql = "UPDATE paises SET nombre = ?, usuario_modificado = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    pais.getNombre(),
                    pais.getUsuario_modificado() != null ? pais.getUsuario_modificado() : "defaultUser",
                    pais.getUpdated_at() != null ? Timestamp.valueOf(pais.getUpdated_at()) : new Timestamp(System.currentTimeMillis()),
                    pais.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar país: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar país", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM paises WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar país: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar país", e);
        }
    }

    @Override
    public Paises findById(int id) throws DaoException {
        String sql = "SELECT id, nombre, usuario_modificado, created_at, updated_at FROM paises WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapPaises(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar país por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar país por ID", e);
        }
    }

    @Override
    public List<Paises> findAll() throws DaoException {
        String sql = "SELECT id, nombre, usuario_modificado, created_at, updated_at FROM paises";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapPaises(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar países: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar países", e);
        }
    }

    private Paises mapPaises(ResultSet rs) throws SQLException {
        Paises p = new Paises();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setUsuario_modificado(rs.getString("usuario_modificado"));
        p.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        p.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        return p;
    }
}
