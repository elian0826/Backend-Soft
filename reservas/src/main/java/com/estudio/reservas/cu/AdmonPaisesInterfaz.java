package com.estudio.reservas.cu;

import com.estudio.reservas.dto.PaisesDto;

import java.util.List;

public interface AdmonPaisesInterfaz {
    void insert(PaisesDto paisDto) throws RuntimeException;
    void update(PaisesDto paisDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    PaisesDto findById(int id) throws RuntimeException;
    List<PaisesDto> findAll() throws RuntimeException;
}
