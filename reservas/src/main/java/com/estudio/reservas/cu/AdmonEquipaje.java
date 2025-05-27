package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Equipaje;
import com.estudio.reservas.dominio.manager.EquipajeDmInterfaz;
import com.estudio.reservas.dto.EquipajeDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.EquipajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonEquipaje implements AdmonEquipajeInterfaz {

    @Autowired
    private EquipajeDmInterfaz equipajeDmInterfaz;

    @Override
    public void insert(EquipajeDto equipajeDto) throws RuntimeException {
        Equipaje equipaje = EquipajeMapper.mapper.toEquipaje(equipajeDto);
        try {
            equipajeDmInterfaz.createEquipaje(equipaje);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(EquipajeDto equipajeDto) throws RuntimeException {
        Equipaje equipaje = EquipajeMapper.mapper.toEquipaje(equipajeDto);
        try {
            equipajeDmInterfaz.updateEquipaje(equipaje);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            equipajeDmInterfaz.deleteEquipaje(id);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EquipajeDto findById(int id) throws RuntimeException {
        try {
            Equipaje equipaje = equipajeDmInterfaz.getEquipajeById(id);
            return EquipajeMapper.mapper.toEquipajeDto(equipaje);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EquipajeDto> findAll() throws RuntimeException {
        try {
            List<Equipaje> equipajes = equipajeDmInterfaz.getAllEquipajes();
            return EquipajeMapper.mapper.toListEntityDto(equipajes);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }
}
