package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface PaisesDaoInterfaz {
    void insert(Paises pais) throws DaoException;
    void update(Paises pais) throws DaoException;
    void delete(int id) throws DaoException;
    Paises findById(int id) throws DaoException;
    List<Paises> findAll() throws DaoException;
}
