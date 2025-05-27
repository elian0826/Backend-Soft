package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Ciudad;
import com.estudio.reservas.exception.DmException;

import java.util.List;

public interface CiudadDmInterfaz {
    void createCiudad(Ciudad ciudad) throws DmException;
    void updateCiudad(Ciudad ciudad) throws DmException;
    void deleteCiudad(int id) throws DmException;
    Ciudad getCiudadById(int id) throws DmException;
    List<Ciudad> getAllCiudades() throws DmException;
}
