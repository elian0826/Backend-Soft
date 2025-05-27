package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.ClientesDao;
import com.estudio.reservas.dominio.dao.ClientesDaoInterfaz;
import com.estudio.reservas.dominio.entidades.Clientes;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesDm implements ClientesDmInterfaz {

    @Autowired
    private ClientesDaoInterfaz clientesDao;

    @Override
    public void createCliente(Clientes cliente) throws DmException {
        try {
            clientesDao.insertar(cliente);
        } catch (DaoException e) {
            throw new DmException("Error al crear cliente", e);
        }
    }

    @Override
    public void updateCliente(Clientes cliente) throws DmException {
        try {
            clientesDao.update(cliente);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar cliente", e);
        }
    }

    @Override
    public void deleteCliente(int id) throws DmException {
        try {
            clientesDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar cliente con ID: " + id, e);
        }
    }

    @Override
    public Clientes getClienteById(int id) throws DmException {
        try {
            return clientesDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener cliente con ID: " + id, e);
        }
    }

    @Override
    public List<Clientes> getAllClientes() throws DmException {
        try {
            return clientesDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener lista de clientes", e);
        }
    }

    @Override
    public Clientes getClienteByDocumento(int documento) throws DmException {
        try {
            return clientesDao.findByDocumento(documento);
        } catch (DaoException e) {
            throw new DmException("Error al obtener cliente con documento: " + documento, e);
        }
    }


}
