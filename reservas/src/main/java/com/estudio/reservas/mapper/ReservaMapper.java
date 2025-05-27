package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.Reserva;
import com.estudio.reservas.dto.ReservaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaMapper mapper = Mappers.getMapper(ReservaMapper.class);

    Reserva toReserva(ReservaDto dto);

    ReservaDto toReservaDto(Reserva reserva);

    List<ReservaDto> toListEntityDto(List<Reserva> reservas);

    List<Reserva> toListDtoEntity(List<ReservaDto> reservaDtos);
}
