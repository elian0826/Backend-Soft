package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Aerolinea;
import com.estudio.reservas.dominio.manager.AerolineaDmInterfaz;
import com.estudio.reservas.dto.AerolineaDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.AerolineaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonAerolinea implements AdmonAerolineaInterfaz {

    @Autowired
    private AerolineaDmInterfaz aerolineaDmInterfaz;

    @Override
    public void insert(AerolineaDto aerolineaDto) throws RuntimeException {
        Aerolinea aerolinea = AerolineaMapper.mapper.toAerolinea(aerolineaDto);
        try {
            aerolineaDmInterfaz.createAerolinea(aerolinea);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(AerolineaDto aerolineaDto) throws RuntimeException {
        Aerolinea aerolinea = AerolineaMapper.mapper.toAerolinea(aerolineaDto);
        try {
            aerolineaDmInterfaz.updateAerolinea(aerolinea);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            aerolineaDmInterfaz.deleteAerolinea(id);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AerolineaDto findById(int id) throws RuntimeException {
        try {
            Aerolinea aerolinea = aerolineaDmInterfaz.getAerolineaById(id);
            return AerolineaMapper.mapper.toAerolineaDto(aerolinea);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AerolineaDto> findAll() throws RuntimeException {
        try {
            List<Aerolinea> aerolineas = aerolineaDmInterfaz.getAllAerolineas();
            return AerolineaMapper.mapper.toListEntityDto(aerolineas);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }
}
