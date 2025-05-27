package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.Equipaje;
import com.estudio.reservas.dto.EquipajeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipajeMapper {
    EquipajeMapper mapper = Mappers.getMapper(EquipajeMapper.class);

    EquipajeDto toEquipajeDto(Equipaje equipaje);
    Equipaje toEquipaje(EquipajeDto equipajeDto);

    List<EquipajeDto> toListEntityDto(List<Equipaje> equipajes);
    List<Equipaje> toListDtoEntity(List<EquipajeDto> equipajesDto);
}
