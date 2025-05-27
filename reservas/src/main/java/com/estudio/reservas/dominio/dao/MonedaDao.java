package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Moneda;
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
public class MonedaDao implements MonedaDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Moneda moneda) throws DaoException {
        String sql = "INSERT INTO moneda (tipo_moneda, usuario_modificado, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    moneda.getTipo_moneda(),
                    moneda.getUsuario_modificado() != null ? moneda.getUsuario_modificado() : "defaultUser",
                    moneda.getCreated_at() != null ? Timestamp.valueOf(moneda.getCreated_at()) : new Timestamp(System.currentTimeMillis()),
                    moneda.getUpdated_at() != null ? Timestamp.valueOf(moneda.getUpdated_at()) : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar moneda: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar moneda", e);
        }
    }

    @Override
    public void update(Moneda moneda) throws DaoException {
        String sql = "UPDATE moneda SET tipo_moneda = ?, usuario_modificado = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    moneda.getTipo_moneda(),
                    moneda.getUsuario_modificado() != null ? moneda.getUsuario_modificado() : "defaultUser",
                    moneda.getUpdated_at() != null ? Timestamp.valueOf(moneda.getUpdated_at()) : new Timestamp(System.currentTimeMillis()),
                    moneda.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar moneda: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar moneda", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM moneda WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar moneda: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar moneda", e);
        }
    }

    @Override
    public Moneda findById(int id) throws DaoException {
        String sql = "SELECT id, tipo_moneda, usuario_modificado, created_at, updated_at FROM moneda WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapMoneda(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar moneda por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar moneda por ID", e);
        }
    }

    @Override
    public List<Moneda> findAll() throws DaoException {
        String sql = "SELECT id, tipo_moneda, usuario_modificado, created_at, updated_at FROM moneda";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapMoneda(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar monedas: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar monedas", e);
        }
    }

    private Moneda mapMoneda(ResultSet rs) throws SQLException {
        Moneda m = new Moneda();
        m.setId(rs.getInt("id"));
        m.setTipo_moneda(rs.getString("tipo_moneda"));
        m.setUsuario_modificado(rs.getString("usuario_modificado"));
        m.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        m.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        return m;
    }
}
