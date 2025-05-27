package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Reserva;
import com.estudio.reservas.exception.DmException;

import java.util.List;

public interface ReservaDmInterfaz {
    void createReserva(Reserva reserva) throws DmException;
    void updateReserva(Reserva reserva) throws DmException;
    void deleteReserva(int id) throws DmException;
    Reserva getReservaById(int id) throws DmException;
    List<Reserva> getAllReservas() throws DmException;
}
