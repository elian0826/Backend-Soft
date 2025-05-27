package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.ReservaDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Reserva;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservaDm implements ReservaDmInterfaz {

    @Autowired
    private ReservaDaoInterfaz reservaDao;

    @Override
    public void createReserva(Reserva reserva) throws DmException {
        try {
            reservaDao.insert(reserva);
        } catch (DaoException e) {
            throw new DmException("Error al crear la reserva", e);
        }
    }

    @Override
    public void updateReserva(Reserva reserva) throws DmException {
        try {
            reservaDao.update(reserva);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar la reserva", e);
        }
    }

    @Override
    public void deleteReserva(int id) throws DmException {
        try {
            reservaDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar la reserva con ID: " + id, e);
        }
    }

    @Override
    public Reserva getReservaById(int id) throws DmException {
        try {
            return reservaDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener la reserva con ID: " + id, e);
        }
    }

    @Override
    public List<Reserva> getAllReservas() throws DmException {
        try {
            return reservaDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener la lista de reservas", e);
        }
    }
}
