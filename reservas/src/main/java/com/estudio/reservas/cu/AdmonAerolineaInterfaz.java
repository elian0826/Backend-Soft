package com.estudio.reservas.cu;

import com.estudio.reservas.dto.AerolineaDto;

import java.util.List;

public interface AdmonAerolineaInterfaz {
    void insert(AerolineaDto aerolineaDto) throws RuntimeException;
    void update(AerolineaDto aerolineaDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    AerolineaDto findById(int id) throws RuntimeException;
    List<AerolineaDto> findAll() throws RuntimeException;
}
