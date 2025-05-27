package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.AerolineaDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Aerolinea;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AerolineaDm implements AerolineaDmInterfaz {

    @Autowired
    private AerolineaDaoInterfaz aerolineaDao;

    @Override
    public void createAerolinea(Aerolinea aerolinea) throws DmException {
        try {
            aerolineaDao.insert(aerolinea);
        } catch (DaoException e) {
            throw new DmException("Error al crear la aerolínea", e);
        }
    }

    @Override
    public void updateAerolinea(Aerolinea aerolinea) throws DmException {
        try {
            aerolineaDao.update(aerolinea);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar la aerolínea", e);
        }
    }

    @Override
    public void deleteAerolinea(int id) throws DmException {
        try {
            aerolineaDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar la aerolínea con ID: " + id, e);
        }
    }

    @Override
    public Aerolinea getAerolineaById(int id) throws DmException {
        try {
            return aerolineaDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener la aerolínea con ID: " + id, e);
        }
    }

    @Override
    public List<Aerolinea> getAllAerolineas() throws DmException {
        try {
            return aerolineaDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener la lista de aerolíneas", e);
        }
    }
}
