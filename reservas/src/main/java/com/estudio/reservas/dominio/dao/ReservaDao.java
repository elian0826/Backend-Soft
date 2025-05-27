package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Reserva;
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
public class ReservaDao implements ReservaDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Reserva reserva) throws DaoException {
        String sql = "INSERT INTO reserva (" +
                "numero_vuelos, valor, fecha_vuelos, hora, valor_equipaje, " +
                "cliente_id, aerolinea_id, moneda_id, tipo_pago_id, origen_id, destino_id, " +
                "usuario_modificado, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql,
                    reserva.getNumero_vuelos(),
                    reserva.getValor(),
                    reserva.getFecha_vuelos(),
                    reserva.getHora(),
                    reserva.getValor_equipaje(),
                    reserva.getCliente_id(),
                    reserva.getAerolinea_id(),
                    reserva.getMoneda_id(),
                    reserva.getTipo_pago_id(),
                    reserva.getOrigen_id(),
                    reserva.getDestino_id(),
                    reserva.getUsuario_modificado() != null ? reserva.getUsuario_modificado() : "defaultUser",
                    reserva.getCreated_at() != null ? Timestamp.valueOf(reserva.getCreated_at()) : new Timestamp(System.currentTimeMillis()),
                    reserva.getUpdated_at() != null ? Timestamp.valueOf(reserva.getUpdated_at()) : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar reserva: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar reserva", e);
        }
    }

    @Override
    public void update(Reserva reserva) throws DaoException {
        String sql = "UPDATE reserva SET " +
                "numero_vuelos = ?, valor = ?, fecha_vuelos = ?, hora = ?, valor_equipaje = ?, " +
                "cliente_id = ?, aerolinea_id = ?, moneda_id = ?, tipo_pago_id = ?, origen_id = ?, destino_id = ?, " +
                "usuario_modificado = ?, updated_at = ? WHERE id = ?";

        try {
            jdbcTemplate.update(sql,
                    reserva.getNumero_vuelos(),
                    reserva.getValor(),
                    reserva.getFecha_vuelos(),
                    reserva.getHora(),
                    reserva.getValor_equipaje(),
                    reserva.getCliente_id(),
                    reserva.getAerolinea_id(),
                    reserva.getMoneda_id(),
                    reserva.getTipo_pago_id(),
                    reserva.getOrigen_id(),
                    reserva.getDestino_id(),
                    reserva.getUsuario_modificado() != null ? reserva.getUsuario_modificado() : "defaultUser",
                    reserva.getUpdated_at() != null ? Timestamp.valueOf(reserva.getUpdated_at()) : new Timestamp(System.currentTimeMillis()),
                    reserva.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar reserva: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar reserva", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM reserva WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar reserva: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar reserva", e);
        }
    }

    @Override
    public Reserva findById(int id) throws DaoException {
        String sql = "SELECT * FROM reserva WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapReserva(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar reserva por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar reserva por ID", e);
        }
    }

    @Override
    public List<Reserva> findAll() throws DaoException {
        String sql = "SELECT * FROM reserva";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapReserva(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar reservas: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar reservas", e);
        }
    }

    private Reserva mapReserva(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt("id"));
        reserva.setNumero_vuelos(rs.getInt("numero_vuelos"));
        reserva.setValor(rs.getBigDecimal("valor"));
        reserva.setFecha_vuelos(rs.getDate("fecha_vuelos").toLocalDate());
        reserva.setHora(rs.getTime("hora").toLocalTime());
        reserva.setValor_equipaje(rs.getBigDecimal("valor_equipaje"));
        reserva.setCliente_id(rs.getInt("cliente_id"));
        reserva.setAerolinea_id(rs.getInt("aerolinea_id"));
        reserva.setMoneda_id(rs.getInt("moneda_id"));
        reserva.setTipo_pago_id(rs.getInt("tipo_pago_id"));
        reserva.setOrigen_id(rs.getInt("origen_id"));
        reserva.setDestino_id(rs.getInt("destino_id"));
        reserva.setUsuario_modificado(rs.getString("usuario_modificado"));
        reserva.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        reserva.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        return reserva;
    }
}
