package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Moneda;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface MonedaDaoInterfaz {
    void insert(Moneda moneda) throws DaoException;
    void update(Moneda moneda) throws DaoException;
    void delete(int id) throws DaoException;
    Moneda findById(int id) throws DaoException;
    List<Moneda> findAll() throws DaoException;
}
