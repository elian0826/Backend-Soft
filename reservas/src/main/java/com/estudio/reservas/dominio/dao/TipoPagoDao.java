package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.TipoPago;
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
public class TipoPagoDao implements TipoPagoDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(TipoPago tipoPago) throws DaoException {
        String sql = "INSERT INTO tipo_pago (medio_pago, usuario_modificado, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    tipoPago.getMedio_pago(),
                    tipoPago.getUsuario_modificado() != null ? tipoPago.getUsuario_modificado() : "defaultUser",
                    tipoPago.getCreated_at() != null ? Timestamp.valueOf(tipoPago.getCreated_at()) : new Timestamp(System.currentTimeMillis()),
                    tipoPago.getUpdated_at() != null ? Timestamp.valueOf(tipoPago.getUpdated_at()) : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar tipo de pago: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar tipo de pago", e);
        }
    }

    @Override
    public void update(TipoPago tipoPago) throws DaoException {
        String sql = "UPDATE tipo_pago SET medio_pago = ?, usuario_modificado = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    tipoPago.getMedio_pago(),
                    tipoPago.getUsuario_modificado() != null ? tipoPago.getUsuario_modificado() : "defaultUser",
                    tipoPago.getUpdated_at() != null ? Timestamp.valueOf(tipoPago.getUpdated_at()) : new Timestamp(System.currentTimeMillis()),
                    tipoPago.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar tipo de pago: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar tipo de pago", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM tipo_pago WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar tipo de pago: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar tipo de pago", e);
        }
    }

    @Override
    public TipoPago findById(int id) throws DaoException {
        String sql = "SELECT id, medio_pago, usuario_modificado, created_at, updated_at FROM tipo_pago WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapTipoPago(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar tipo de pago por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar tipo de pago por ID", e);
        }
    }

    @Override
    public List<TipoPago> findAll() throws DaoException {
        String sql = "SELECT id, medio_pago, usuario_modificado, created_at, updated_at FROM tipo_pago";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapTipoPago(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar tipos de pago: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar tipos de pago", e);
        }
    }

    private TipoPago mapTipoPago(ResultSet rs) throws SQLException {
        TipoPago tp = new TipoPago();
        tp.setId(rs.getInt("id"));
        tp.setMedio_pago(rs.getString("medio_pago"));
        tp.setUsuario_modificado(rs.getString("usuario_modificado"));
        tp.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        tp.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        return tp;
    }
}
