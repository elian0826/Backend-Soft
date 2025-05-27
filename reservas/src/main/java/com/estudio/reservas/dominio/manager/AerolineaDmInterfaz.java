package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Aerolinea;
import com.estudio.reservas.exception.DmException;

import java.util.List;

public interface AerolineaDmInterfaz {

    void createAerolinea(Aerolinea aerolinea) throws DmException;

    void updateAerolinea(Aerolinea aerolinea) throws DmException;

    void deleteAerolinea(int id) throws DmException;

    Aerolinea getAerolineaById(int id) throws DmException;

    List<Aerolinea> getAllAerolineas() throws DmException;
}