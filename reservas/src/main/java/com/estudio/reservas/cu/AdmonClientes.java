package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Clientes;
import com.estudio.reservas.dominio.manager.ClientesDmInterfaz;
import com.estudio.reservas.dto.ClientesDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonClientes implements AdmonClientesInterfaz {

    @Autowired
    private ClientesDmInterfaz clientesDmInterfaz;

    @Override
    public void insert(ClientesDto clientesDto) throws RuntimeException {
        Clientes cliente = ClienteMapper.mapper.toClientes(clientesDto);
        try {
            clientesDmInterfaz.createCliente(cliente);
        } catch (DmException e) {
            throw new RuntimeException("Error insertando cliente", e);
        }
    }

    @Override
    public void update(ClientesDto clientesDto) throws RuntimeException {
        Clientes cliente = ClienteMapper.mapper.toClientes(clientesDto);
        try {
            clientesDmInterfaz.updateCliente(cliente);
        } catch (DmException e) {
            throw new RuntimeException("Error actualizando cliente", e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            clientesDmInterfaz.deleteCliente(id);
        } catch (DmException e) {
            throw new RuntimeException("Error eliminando cliente", e);
        }
    }

    @Override
    public ClientesDto findById(int id) throws RuntimeException {
        try {
            Clientes cliente = clientesDmInterfaz.getClienteById(id);
            return ClienteMapper.mapper.toClientesDto(cliente);
        } catch (DmException e) {
            throw new RuntimeException("Error buscando cliente por ID", e);
        }
    }

    @Override
    public List<ClientesDto> findAll() throws RuntimeException {
        try {
            List<Clientes> clientes = clientesDmInterfaz.getAllClientes();
            return ClienteMapper.mapper.toListEntityDto(clientes);
        } catch (DmException e) {
            throw new RuntimeException("Error listando clientes", e);
        }
    }

    @Override
    public ClientesDto findByDocumento(int documento) throws RuntimeException {
        try {
            Clientes cliente = clientesDmInterfaz.getClienteByDocumento(documento);
            return ClienteMapper.mapper.toClientesDto(cliente);
        } catch (DmException e) {
            throw new RuntimeException("Error buscando cliente por documento", e);
        }
    }

}
