package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.CiudadDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Ciudad;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadDm implements CiudadDmInterfaz {

    @Autowired
    private CiudadDaoInterfaz ciudadDao;

    @Override
    public void createCiudad(Ciudad ciudad) throws DmException {

        try {
            ciudadDao.insertar(ciudad);
        } catch (DaoException e) {
            throw new DmException("Error al crear la ciudad", e);
        }
    }

    @Override
    public void updateCiudad(Ciudad ciudad) throws DmException {
        try {
            ciudadDao.update(ciudad);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar ciudad", e);
        }
    }

    @Override
    public void deleteCiudad(int id) throws DmException {
        try {
            ciudadDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar ciudad con ID: " + id, e);
        }
    }

    @Override
    public Ciudad getCiudadById(int id) throws DmException {
        try {
            return ciudadDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener ciudad con ID: " + id, e);
        }
    }

    @Override
    public List<Ciudad> getAllCiudades() throws DmException {
        try {
            return ciudadDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener la lista de ciudades", e);
        }
}
}
