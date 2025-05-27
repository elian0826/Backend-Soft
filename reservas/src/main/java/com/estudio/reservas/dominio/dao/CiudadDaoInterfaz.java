package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Ciudad;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface CiudadDaoInterfaz {

    void insertar(Ciudad ciudad) throws DaoException;

    void update(Ciudad ciudad)  throws DaoException;

    void delete(int id)  throws DaoException;

    Ciudad findById(int id)  throws DaoException;

    List<Ciudad> findAll()  throws DaoException;
}
