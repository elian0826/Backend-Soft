package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.TipoPago;
import com.estudio.reservas.exception.DmException;

import java.util.List;

public interface TipoPagoDmInterfaz {
    void createTipoPago(TipoPago tipoPago) throws DmException;
    void updateTipoPago(TipoPago tipoPago) throws DmException;
    void deleteTipoPago(int id) throws DmException;
    TipoPago getTipoPagoById(int id) throws DmException;
    List<TipoPago> getAllTipoPago() throws DmException;
}
