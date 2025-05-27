package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Reserva;
import com.estudio.reservas.dominio.manager.ReservaDmInterfaz;
import com.estudio.reservas.dto.ReservaDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonReserva implements AdmonReservaInterfaz {

    @Autowired
    private ReservaDmInterfaz reservaDm;

    @Override
    public void insert(ReservaDto reservaDto) throws RuntimeException {
        Reserva reserva = ReservaMapper.mapper.toReserva(reservaDto);
        try {
            reservaDm.createReserva(reserva);
        } catch (DmException e) {
            throw new RuntimeException("Error insertando reserva", e);
        }
    }

    @Override
    public void update(ReservaDto reservaDto) throws RuntimeException {
        Reserva reserva = ReservaMapper.mapper.toReserva(reservaDto);
        try {
            reservaDm.updateReserva(reserva);
        } catch (DmException e) {
            throw new RuntimeException("Error actualizando reserva", e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            reservaDm.deleteReserva(id);
        } catch (DmException e) {
            throw new RuntimeException("Error eliminando reserva", e);
        }
    }

    @Override
    public ReservaDto findById(int id) throws RuntimeException {
        try {
            Reserva reserva = reservaDm.getReservaById(id);
            return ReservaMapper.mapper.toReservaDto(reserva);
        } catch (DmException e) {
            throw new RuntimeException("Error buscando reserva por ID", e);
        }
    }

    @Override
    public List<ReservaDto> findAll() throws RuntimeException {
        try {
            List<Reserva> reservas = reservaDm.getAllReservas();
            return ReservaMapper.mapper.toListEntityDto(reservas);
        } catch (DmException e) {
            throw new RuntimeException("Error listando reservas", e);
        }
    }
}
