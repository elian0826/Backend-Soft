package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Moneda;
import com.estudio.reservas.exception.DmException;
import java.util.List;

public interface MonedaDmInterfaz {
    void createMoneda(Moneda moneda) throws DmException;
    void updateMoneda(Moneda moneda) throws DmException;
    void deleteMoneda(int id) throws DmException;
    Moneda getMonedaById(int id) throws DmException;
    List<Moneda> getAllMonedas() throws DmException;
}
