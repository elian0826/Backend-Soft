package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Aerolinea;
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
public class AerolineaDao implements AerolineaDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Aerolinea aerolinea) throws DaoException {
        String sql = "INSERT INTO aerolinea (nombre, usuario_modificado, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    aerolinea.getNombre(),
                    aerolinea.getUsuarioModificado() != null ? aerolinea.getUsuarioModificado() : "defaultUser",
                    aerolinea.getCreatedAt() != null ? aerolinea.getCreatedAt() : new Timestamp(System.currentTimeMillis()),
                    aerolinea.getUpdatedAt() != null ? aerolinea.getUpdatedAt() : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar aerolínea: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar aerolínea", e);
        }
    }


    @Override
    public void update(Aerolinea aerolinea) throws DaoException {
        String sql = "UPDATE aerolinea SET nombre = ?, usuario_modificado = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    aerolinea.getNombre(),
                    aerolinea.getUsuarioModificado() != null ? aerolinea.getUsuarioModificado() : "defaultUser",
                    aerolinea.getUpdatedAt() != null ? aerolinea.getUpdatedAt() : new Timestamp(System.currentTimeMillis()),
                    aerolinea.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar aerolínea: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar aerolínea", e);
        }
    }


    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM aerolinea WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar aerolínea: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar aerolínea", e);
        }
    }

    @Override
    public Aerolinea findById(int id) throws DaoException {
        String sql = "SELECT * FROM aerolinea WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapAerolinea(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar aerolínea por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar aerolínea por ID", e);
        }
    }

    @Override
    public List<Aerolinea> findAll() throws DaoException {
        String sql = "SELECT * FROM aerolinea";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapAerolinea(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar aerolíneas: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar aerolíneas", e);
        }
    }

    private Aerolinea mapAerolinea(ResultSet rs) throws SQLException {
        Aerolinea a = new Aerolinea();
        a.setId(rs.getInt("id"));
        a.setNombre(rs.getString("nombre"));
        a.setUsuarioModificado(rs.getString("usuario_modificado"));
        a.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        a.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
        return a;
    }
}
