package com.estudio.reservas.dominio.dao;

import com.estudio.reservas.dominio.entidades.Equipaje;
import com.estudio.reservas.exception.DaoException;

import java.util.List;

public interface EquipajeDaoInterfaz {

    void insert(Equipaje equipaje) throws DaoException;

    void update(Equipaje equipaje) throws DaoException;

    void delete(int id) throws DaoException;

    Equipaje findById(int id) throws DaoException;

    List<Equipaje> findAll() throws DaoException;

}
