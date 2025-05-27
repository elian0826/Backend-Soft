package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Aerolinea;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface AerolineaDaoInterfaz {

    void insert(Aerolinea aerolinea) throws DaoException;

    void update(Aerolinea aerolinea) throws DaoException;

    void delete(int id) throws DaoException;

    Aerolinea findById(int id) throws DaoException;

    List<Aerolinea> findAll() throws DaoException;
}
