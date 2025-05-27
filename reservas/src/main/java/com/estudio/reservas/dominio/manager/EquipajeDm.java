package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.EquipajeDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Equipaje;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipajeDm implements EquipajeDmInterfaz {

    @Autowired
    private EquipajeDaoInterfaz equipajeDao;

    @Override
    public void createEquipaje(Equipaje equipaje) throws DmException {
        try {
            equipajeDao.insert(equipaje);
        } catch (DaoException e) {
            throw new DmException("Error al crear equipaje", e);
        }
    }

    @Override
    public void updateEquipaje(Equipaje equipaje) throws DmException {
        try {
            equipajeDao.update(equipaje);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar equipaje", e);
        }
    }

    @Override
    public void deleteEquipaje(int id) throws DmException {
        try {
            equipajeDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar equipaje con ID: " + id, e);
        }
    }

    @Override
    public Equipaje getEquipajeById(int id) throws DmException {
        try {
            return equipajeDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener equipaje con ID: " + id, e);
        }
    }

    @Override
    public List<Equipaje> getAllEquipajes() throws DmException {
        try {
            return equipajeDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener lista de equipajes", e);
        }
    }
}
