package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Clientes;
import com.estudio.reservas.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ClientesDao implements ClientesDaoInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertar(Clientes cliente) throws DaoException {
        String sql = "INSERT INTO clientes (documento, nombre, fecha_nacimiento, telefono, email, usuario_modificado, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                    cliente.getDocumento(),
                    cliente.getNombre(),
                    Date.valueOf(cliente.getFecha_nacimiento()),
                    cliente.getTelefono(),
                    cliente.getEmail(),
                    cliente.getUsuario_modificado() != null ? cliente.getUsuario_modificado() : "defaultUser",
                    cliente.getCreated_at() != null ? Timestamp.valueOf(cliente.getCreated_at()) : new Timestamp(System.currentTimeMillis()),
                    cliente.getUpdated_at() != null ? Timestamp.valueOf(cliente.getUpdated_at()) : new Timestamp(System.currentTimeMillis())
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al insertar cliente: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al insertar cliente", e);
        }
    }

    @Override
    public void update(Clientes cliente) throws DaoException {
        String sql = "UPDATE clientes SET documento = ?, nombre = ?, fecha_nacimiento = ?, telefono = ?, email = ?, usuario_modificado = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    cliente.getDocumento(),
                    cliente.getNombre(),
                    Date.valueOf(cliente.getFecha_nacimiento()),
                    cliente.getTelefono(),
                    cliente.getEmail(),
                    cliente.getUsuario_modificado() != null ? cliente.getUsuario_modificado() : "defaultUser",
                    cliente.getUpdated_at() != null ? Timestamp.valueOf(cliente.getUpdated_at()) : new Timestamp(System.currentTimeMillis()),
                    cliente.getId()
            );
        } catch (DataAccessException ex) {
            throw new DaoException("Error al actualizar cliente: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al actualizar cliente", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al eliminar cliente: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al eliminar cliente", e);
        }
    }

    @Override
    public Clientes findById(int id) throws DaoException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapCliente(rs), id);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar cliente por ID: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar cliente por ID", e);
        }
    }

    @Override
    public List<Clientes> findAll() throws DaoException {
        String sql = "SELECT * FROM clientes";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapCliente(rs));
        } catch (DataAccessException ex) {
            throw new DaoException("Error al listar clientes: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al listar clientes", e);
        }
    }

    private Clientes mapCliente(ResultSet rs) throws SQLException {
        Clientes cliente = new Clientes();
        cliente.setId(rs.getInt("id"));
        cliente.setDocumento(rs.getInt("documento"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setEmail(rs.getString("email"));
        cliente.setUsuario_modificado(rs.getString("usuario_modificado"));

        Timestamp created = rs.getTimestamp("created_at");
        if (created != null) {
            cliente.setCreated_at(created.toLocalDateTime());
        }

        Timestamp updated = rs.getTimestamp("updated_at");
        if (updated != null) {
            cliente.setUpdated_at(updated.toLocalDateTime());
        }

        return cliente;
    }

    @Override
    public Clientes findByDocumento(int documento) throws DaoException {
        String sql = "SELECT * FROM clientes WHERE documento = ?";
        try {
            List<Clientes> resultados = jdbcTemplate.query(sql, (rs, rowNum) -> mapCliente(rs), documento);
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (DataAccessException ex) {
            throw new DaoException("Error al buscar cliente por documento: " + ex.getMessage(), ex);
        } catch (Exception e) {
            throw new DaoException("Error inesperado al buscar cliente por documento", e);
        }
    }



}
