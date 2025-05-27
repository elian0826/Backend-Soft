package com.estudio.reservas.mapper;

import com.estudio.reservas.dominio.entidades.Clientes;
import com.estudio.reservas.dto.ClientesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface ClienteMapper  {
    ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);

    ClientesDto toClientesDto(Clientes cliente);
    Clientes toClientes(ClientesDto clienteDto);

    List<ClientesDto> toListEntityDto(List<Clientes> clientes);
    List<Clientes> toListDtoEntity(List<ClientesDto> clientesDto);
}
