package com.estudio.reservas.cu;

import com.estudio.reservas.dto.CiudadDto;

import java.util.List;

public interface AdmonCiudadInterfaz {
    void insert(CiudadDto ciudadDto) throws RuntimeException;
    void update(CiudadDto ciudadDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    CiudadDto findById(int id) throws RuntimeException;
    List<CiudadDto> findAll() throws RuntimeException;
}
