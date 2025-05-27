package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Equipaje;
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
public class EquipajeDao implements EquipajeDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String DEFAULT_USER = "defaultUser";

    @Override
    public void insert(Equipaje equipaje) throws DaoException {
        String sql = "INSERT INTO equipaje (tipo_equipaje, peso, precio, moneda_id, reserva_id, usuario_modificado, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    equipaje.getTipo_equipaje(),
                    equipaje.getPeso(),
                    equipaje.getPrecio(),
                    equipaje.getMoneda_id(),
                    equipaje.getReserva_id(),
                    usuarioOrDefault(equipaje.getUsuario_modificado()),
                    toTimestampOrNow(equipaje.getCreated_at()),
                    toTimestampOrNow(equipaje.getUpdated_at())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar equipaje: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar equipaje", e);
        }
    }

    @Override
    public void update(Equipaje equipaje) throws DaoException {
        String sql = "UPDATE equipaje SET tipo_equipaje = ?, peso = ?, precio = ?, moneda_id = ?, reserva_id = ?, usuario_modificado = ?, updated_at = ? " +
                "WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    equipaje.getTipo_equipaje(),
                    equipaje.getPeso(),
                    equipaje.getPrecio(),
                    equipaje.getMoneda_id(),
                    equipaje.getReserva_id(),
                    usuarioOrDefault(equipaje.getUsuario_modificado()),
                    toTimestampOrNow(equipaje.getUpdated_at()),
                    equipaje.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar equipaje: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar equipaje", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM equipaje WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar equipaje: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar equipaje", e);
        }
    }

    @Override
    public Equipaje findById(int id) throws DaoException {
        String sql = "SELECT * FROM equipaje WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapEquipaje(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar equipaje por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar equipaje por ID", e);
        }
    }

    @Override
    public List<Equipaje> findAll() throws DaoException {
        String sql = "SELECT * FROM equipaje";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapEquipaje(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar equipajes: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar equipajes", e);
        }
    }

    private Equipaje mapEquipaje(ResultSet rs) throws SQLException {
        Equipaje equipaje = new Equipaje();
        equipaje.setId(rs.getInt("id"));
        equipaje.setTipo_equipaje(rs.getString("tipo_equipaje"));
        equipaje.setPeso(rs.getBigDecimal("peso"));
        equipaje.setPrecio(rs.getBigDecimal("precio"));
        equipaje.setMoneda_id(rs.getInt("moneda_id"));
        equipaje.setReserva_id(rs.getInt("reserva_id"));
        equipaje.setUsuario_modificado(rs.getString("usuario_modificado"));

        Timestamp createdAt = rs.getTimestamp("created_at");
        if (createdAt != null) {
            equipaje.setCreated_at(createdAt.toLocalDateTime());
        }

        Timestamp updatedAt = rs.getTimestamp("updated_at");
        if (updatedAt != null) {
            equipaje.setUpdated_at(updatedAt.toLocalDateTime());
        }

        return equipaje;
    }

    // Métodos auxiliares para evitar repetición
    private Timestamp toTimestampOrNow(java.time.LocalDateTime ldt) {
        return (ldt != null) ? Timestamp.valueOf(ldt) : new Timestamp(System.currentTimeMillis());
    }

    private String usuarioOrDefault(String usuario) {
        return (usuario != null) ? usuario : DEFAULT_USER;
    }
}
