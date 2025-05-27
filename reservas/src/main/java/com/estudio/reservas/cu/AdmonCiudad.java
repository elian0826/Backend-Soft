package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Ciudad;
import com.estudio.reservas.dominio.manager.CiudadDmInterfaz;
import com.estudio.reservas.dto.CiudadDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.CiudadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonCiudad implements AdmonCiudadInterfaz {

    @Autowired
    private CiudadDmInterfaz ciudadDmInterfaz;

    @Override
    public void insert(CiudadDto ciudadDto) throws RuntimeException {
        Ciudad ciudad = CiudadMapper.mapper.toCiudad(ciudadDto);
        try {
            ciudadDmInterfaz.createCiudad(ciudad);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(CiudadDto ciudadDto) throws RuntimeException {
        Ciudad ciudad = CiudadMapper.mapper.toCiudad(ciudadDto);
        try {
            ciudadDmInterfaz.updateCiudad(ciudad);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            ciudadDmInterfaz.deleteCiudad(id);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CiudadDto findById(int id) throws RuntimeException {
        try {
            Ciudad ciudad = ciudadDmInterfaz.getCiudadById(id);
            return CiudadMapper.mapper.toCiudadDto(ciudad);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CiudadDto> findAll() throws RuntimeException {
        try {
            List<Ciudad> ciudades = ciudadDmInterfaz.getAllCiudades();
            return CiudadMapper.mapper.toListEntityDto(ciudades);
        } catch (DmException e) {
            throw new RuntimeException(e);
        }
    }

}
