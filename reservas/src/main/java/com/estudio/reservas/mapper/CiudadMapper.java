package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.Ciudad;
import com.estudio.reservas.dto.CiudadDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CiudadMapper {
    CiudadMapper mapper = Mappers.getMapper(CiudadMapper.class);

    CiudadDto toCiudadDto(Ciudad ciudad);
    Ciudad toCiudad(CiudadDto ciudadDto);

    List<CiudadDto> toListEntityDto(List<Ciudad> ciudades);
    List<Ciudad> toListDtoEntity(List<CiudadDto> ciudadDtos);
}
