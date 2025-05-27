package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.exception.DmException;

import java.util.List;

public interface PaisesDmInterfaz {
    void createPais(Paises pais) throws DmException;
    void updatePais(Paises pais) throws DmException;
    void deletePais(int id) throws DmException;
    Paises getPaisById(int id) throws DmException;
    List<Paises> getAllPaises() throws DmException;
}
