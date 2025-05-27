package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.PaisesDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisesDm implements PaisesDmInterfaz {

    @Autowired
    private PaisesDaoInterfaz paisesDao;

    @Override
    public void createPais(Paises pais) throws DmException {
        try {
            paisesDao.insert(pais);
        } catch (DaoException e) {
            throw new DmException("Error al crear el país", e);
        }
    }

    @Override
    public void updatePais(Paises pais) throws DmException {
        try {
            paisesDao.update(pais);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar el país", e);
        }
    }

    @Override
    public void deletePais(int id) throws DmException {
        try {
            paisesDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar el país con ID: " + id, e);
        }
    }

    @Override
    public Paises getPaisById(int id) throws DmException {
        try {
            return paisesDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener el país con ID: " + id, e);
        }
    }

    @Override
    public List<Paises> getAllPaises() throws DmException {
        try {
            return paisesDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener la lista de países", e);
        }
    }
}
