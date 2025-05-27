package com.estudio.reservas.cu;

import com.estudio.reservas.dto.MonedaDto;

import java.util.List;

public interface AdmonMonedaInterfaz {
    void insert(MonedaDto monedaDto) throws RuntimeException;
    void update(MonedaDto monedaDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    MonedaDto findById(int id) throws RuntimeException;
    List<MonedaDto> findAll() throws RuntimeException;
}
