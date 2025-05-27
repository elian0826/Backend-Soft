package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.MonedaDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Moneda;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaDm implements MonedaDmInterfaz {

    @Autowired
    private MonedaDaoInterfaz monedaDao;

    @Override
    public void createMoneda(Moneda moneda) throws DmException {
        try {
            monedaDao.insert(moneda);
        } catch (DaoException e) {
            throw new DmException("Error al crear la moneda", e);
        }
    }

    @Override
    public void updateMoneda(Moneda moneda) throws DmException {
        try {
            monedaDao.update(moneda);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar la moneda", e);
        }
    }

    @Override
    public void deleteMoneda(int id) throws DmException {
        try {
            monedaDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar la moneda con ID: " + id, e);
        }
    }

    @Override
    public Moneda getMonedaById(int id) throws DmException {
        try {
            return monedaDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener la moneda con ID: " + id, e);
        }
    }

    @Override
    public List<Moneda> getAllMonedas() throws DmException {
        try {
            return monedaDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener la lista de monedas", e);
        }
    }
}
