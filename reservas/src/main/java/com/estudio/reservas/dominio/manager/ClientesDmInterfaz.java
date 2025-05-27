package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Clientes;
import com.estudio.reservas.exception.DmException;

import java.util.List;

public interface ClientesDmInterfaz {
    void createCliente(Clientes cliente) throws DmException;
    void updateCliente(Clientes cliente) throws DmException;
    void deleteCliente(int id) throws DmException;
    Clientes getClienteById(int id) throws DmException;
    List<Clientes> getAllClientes() throws DmException;
    Clientes getClienteByDocumento(int documento) throws DmException;


}
