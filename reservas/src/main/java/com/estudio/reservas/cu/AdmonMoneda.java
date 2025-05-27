package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Moneda;
import com.estudio.reservas.dominio.manager.MonedaDmInterfaz;
import com.estudio.reservas.dto.MonedaDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.MonedaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonMoneda implements AdmonMonedaInterfaz {

    @Autowired
    private MonedaDmInterfaz monedaDm;

    @Override
    public void insert(MonedaDto monedaDto) throws RuntimeException {
        Moneda moneda = MonedaMapper.mapper.toMoneda(monedaDto);
        try {
            monedaDm.createMoneda(moneda);
        } catch (DmException e) {
            throw new RuntimeException("Error insertando moneda", e);
        }
    }

    @Override
    public void update(MonedaDto monedaDto) throws RuntimeException {
        Moneda moneda = MonedaMapper.mapper.toMoneda(monedaDto);
        try {
            monedaDm.updateMoneda(moneda);
        } catch (DmException e) {
            throw new RuntimeException("Error actualizando moneda", e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            monedaDm.deleteMoneda(id);
        } catch (DmException e) {
            throw new RuntimeException("Error eliminando moneda", e);
        }
    }

    @Override
    public MonedaDto findById(int id) throws RuntimeException {
        try {
            Moneda moneda = monedaDm.getMonedaById(id);
            return MonedaMapper.mapper.toMonedaDto(moneda);
        } catch (DmException e) {
            throw new RuntimeException("Error buscando moneda por ID", e);
        }
    }

    @Override
    public List<MonedaDto> findAll() throws RuntimeException {
        try {
            List<Moneda> monedas = monedaDm.getAllMonedas();
            return MonedaMapper.mapper.toListEntityDto(monedas);
        } catch (DmException e) {
            throw new RuntimeException("Error listando monedas", e);
        }
    }
}
