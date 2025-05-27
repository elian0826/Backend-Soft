package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Reserva;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface ReservaDaoInterfaz {
    void insert(Reserva reserva) throws DaoException;
    void update(Reserva reserva) throws DaoException;
    void delete(int id) throws DaoException;
    Reserva findById(int id) throws DaoException;
    List<Reserva> findAll() throws DaoException;
}
