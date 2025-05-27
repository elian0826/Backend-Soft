package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.Moneda;
import com.estudio.reservas.dto.MonedaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonedaMapper {
    MonedaMapper mapper = Mappers.getMapper(MonedaMapper.class);

    MonedaDto toMonedaDto(Moneda moneda);
    Moneda toMoneda(MonedaDto monedaDto);

    List<MonedaDto> toListEntityDto(List<Moneda> monedas);
    List<Moneda> toListDtoEntity(List<MonedaDto> monedasDto);
}
