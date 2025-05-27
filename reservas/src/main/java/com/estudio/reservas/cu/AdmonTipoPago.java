package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.TipoPago;
import com.estudio.reservas.dominio.manager.TipoPagoDmInterfaz;
import com.estudio.reservas.dto.TipoPagoDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.TipoPagoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonTipoPago implements AdmonTipoPagoInterfaz {

    @Autowired
    private TipoPagoDmInterfaz tipoPagoDm;

    @Override
    public void insert(TipoPagoDto tipoPagoDto) throws RuntimeException {
        TipoPago tipoPago = TipoPagoMapper.mapper.toTipoPago(tipoPagoDto);
        try {
            tipoPagoDm.createTipoPago(tipoPago);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(TipoPagoDto tipoPagoDto) throws RuntimeException {
        TipoPago tipoPago = TipoPagoMapper.mapper.toTipoPago(tipoPagoDto);
        try {
            tipoPagoDm.updateTipoPago(tipoPago);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            tipoPagoDm.deleteTipoPago(id);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TipoPagoDto findById(int id) throws RuntimeException {
        try {
            TipoPago tipoPago = tipoPagoDm.getTipoPagoById(id);
            return TipoPagoMapper.mapper.toTipoPagoDto(tipoPago);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TipoPagoDto> findAll() throws RuntimeException {
        try {
            List<TipoPago> tipoPagos = tipoPagoDm.getAllTipoPago();
            return TipoPagoMapper.mapper.toListEntityDto(tipoPagos);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }
}
