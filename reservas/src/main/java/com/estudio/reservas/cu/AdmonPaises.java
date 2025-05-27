package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.dominio.manager.PaisesDmInterfaz;
import com.estudio.reservas.dto.PaisesDto;
import com.estudio.reservas.exception.DmException;
import com.estudio.reservas.mapper.PaisesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonPaises implements AdmonPaisesInterfaz {

    @Autowired
    private PaisesDmInterfaz paisesDm;

    @Override
    public void insert(PaisesDto paisDto) throws RuntimeException {
        Paises pais = PaisesMapper.mapper.toPaises(paisDto);
        try {
            paisesDm.createPais(pais);
        } catch (DmException e) {
            throw new RuntimeException("Error insertando país", e);
        }
    }

    @Override
    public void update(PaisesDto paisDto) throws RuntimeException {
        Paises pais = PaisesMapper.mapper.toPaises(paisDto);
        try {
            paisesDm.updatePais(pais);
        } catch (DmException e) {
            throw new RuntimeException("Error actualizando país", e);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        try {
            paisesDm.deletePais(id);
        } catch (DmException e) {
            throw new RuntimeException("Error eliminando país", e);
        }
    }

    @Override
    public PaisesDto findById(int id) throws RuntimeException {
        try {
            Paises pais = paisesDm.getPaisById(id);
            return PaisesMapper.mapper.toPaisesDto(pais);
        } catch (DmException e) {
            throw new RuntimeException("Error buscando país por ID", e);
        }
    }

    @Override
    public List<PaisesDto> findAll() throws RuntimeException {
        try {
            List<Paises> paises = paisesDm.getAllPaises();
            return PaisesMapper.mapper.toListEntityDto(paises);
        } catch (DmException e) {
            throw new RuntimeException("Error listando países", e);
        }
    }
}
