package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.TipoPago;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface TipoPagoDaoInterfaz {
    void insert(TipoPago tipoPago) throws DaoException;
    void update(TipoPago tipoPago) throws DaoException;
    void delete(int id) throws DaoException;
    TipoPago findById(int id) throws DaoException;
    List<TipoPago> findAll() throws DaoException;
}
