package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Clientes;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface ClientesDaoInterfaz {

    void insertar(Clientes cliente) throws DaoException;

    void update(Clientes cliente) throws DaoException;

    void delete(int id) throws DaoException;

    Clientes findById(int id) throws DaoException;

    List<Clientes> findAll() throws DaoException;
    Clientes findByDocumento(int documento) throws DaoException;

}
