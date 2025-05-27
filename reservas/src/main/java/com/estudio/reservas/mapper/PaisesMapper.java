package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.dto.PaisesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaisesMapper {
    PaisesMapper mapper = Mappers.getMapper(PaisesMapper.class);

    PaisesDto toPaisesDto(Paises pais);
    Paises toPaises(PaisesDto paisDto);

    List<PaisesDto> toListEntityDto(List<Paises> paises);
    List<Paises> toListDtoEntity(List<PaisesDto> paisesDto);
}
