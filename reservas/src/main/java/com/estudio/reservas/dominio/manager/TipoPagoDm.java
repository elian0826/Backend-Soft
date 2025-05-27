package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.dao.TipoPagoDaoInterfaz;
import com.estudio.reservas.dominio.entidades.TipoPago;
import com.estudio.reservas.exception.DaoException;
import com.estudio.reservas.exception.DmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoPagoDm implements TipoPagoDmInterfaz {

    @Autowired
    private TipoPagoDaoInterfaz tipoPagoDao;

    @Override
    public void createTipoPago(TipoPago tipoPago) throws DmException {
        try {
            tipoPagoDao.insert(tipoPago);
        } catch (DaoException e) {
            throw new DmException("Error al crear el tipo de pago", e);
        }
    }

    @Override
    public void updateTipoPago(TipoPago tipoPago) throws DmException {
        try {
            tipoPagoDao.update(tipoPago);
        } catch (DaoException e) {
            throw new DmException("Error al actualizar el tipo de pago", e);
        }
    }

    @Override
    public void deleteTipoPago(int id) throws DmException {
        try {
            tipoPagoDao.delete(id);
        } catch (DaoException e) {
            throw new DmException("Error al eliminar el tipo de pago con ID: " + id, e);
        }
    }

    @Override
    public TipoPago getTipoPagoById(int id) throws DmException {
        try {
            return tipoPagoDao.findById(id);
        } catch (DaoException e) {
            throw new DmException("Error al obtener el tipo de pago con ID: " + id, e);
        }
    }

    @Override
    public List<TipoPago> getAllTipoPago() throws DmException {
        try {
            return tipoPagoDao.findAll();
        } catch (DaoException e) {
            throw new DmException("Error al obtener la lista de tipos de pago", e);
        }
    }
}
