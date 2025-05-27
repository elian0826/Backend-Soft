package com.estudio.reservas.cu;

import com.estudio.reservas.dto.ReservaDto;

import java.util.List;

public interface AdmonReservaInterfaz {
    void insert(ReservaDto reservaDto) throws RuntimeException;
    void update(ReservaDto reservaDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    ReservaDto findById(int id) throws RuntimeException;
    List<ReservaDto> findAll() throws RuntimeException;
}
