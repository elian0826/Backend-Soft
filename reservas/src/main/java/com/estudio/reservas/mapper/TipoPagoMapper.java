package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.TipoPago;
import com.estudio.reservas.dto.TipoPagoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoPagoMapper {

    TipoPagoMapper mapper = Mappers.getMapper(TipoPagoMapper.class);

    TipoPagoDto toTipoPagoDto(TipoPago tipoPago);

    TipoPago toTipoPago(TipoPagoDto tipoPagoDto);

    List<TipoPagoDto> toListEntityDto(List<TipoPago> tipoPagos);

    List<TipoPago> toListDtoEntity(List<TipoPagoDto> tipoPagoDtos);
}
