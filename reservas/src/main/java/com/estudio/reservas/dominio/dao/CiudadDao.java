package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Ciudad;
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
public class CiudadDao implements CiudadDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertar(Ciudad ciudad) throws DaoException {
        String sql = "INSERT INTO ciudad (nombre, pais_id, usuario_modificado, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    ciudad.getNombre(),
                    ciudad.getPais_id(),
                    ciudad.getUsuario_modificado() != null ? ciudad.getUsuario_modificado() : "defaultUser",
                    ciudad.getCreated_at() != null ? Timestamp.valueOf(ciudad.getCreated_at()) : new Timestamp(System.currentTimeMillis()),
                    ciudad.getUpdated_at() != null ? Timestamp.valueOf(ciudad.getUpdated_at()) : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar ciudad: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar ciudad", e);
        }
    }


    @Override
    public void update(Ciudad ciudad) throws DaoException {
        String sql = "UPDATE ciudad SET nombre = ?, pais_id = ?, usuario_modificado = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    ciudad.getNombre(),
                    ciudad.getPais_id(),
                    ciudad.getUsuario_modificado() != null ? ciudad.getUsuario_modificado() : "defaultUser",
                    ciudad.getUpdated_at() != null ? Timestamp.valueOf(ciudad.getUpdated_at()) : new Timestamp(System.currentTimeMillis()),
                    ciudad.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar ciudad: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar ciudad", e);
        }
    }


    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM ciudad WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar ciudad: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar ciudad", e);
        }
    }


    @Override
    public Ciudad findById(int id) throws DaoException {
        String sql = "SELECT id, nombre, pais_id, usuario_modificado, created_at, updated_at FROM ciudad WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapCiudad(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar ciudad por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar ciudad por ID", e);
        }
    }


    @Override
    public List<Ciudad> findAll() throws DaoException {
        String sql = "SELECT id, nombre, pais_id, usuario_modificado, created_at, updated_at FROM ciudad";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapCiudad(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar ciudades: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar ciudades", e);
        }
    }


    private Ciudad mapCiudad(ResultSet rs) throws SQLException {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(rs.getInt("id"));
        ciudad.setNombre(rs.getString("nombre"));
        ciudad.setPais_id(rs.getInt("pais_id"));
        ciudad.setUsuario_modificado(rs.getString("usuario_modificado"));
        ciudad.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        ciudad.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        return ciudad;
    }
}
