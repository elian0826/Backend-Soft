package com.estudio.reservas.cu;

import com.estudio.reservas.dto.EquipajeDto;

import java.util.List;

public interface AdmonEquipajeInterfaz {
    void insert(EquipajeDto equipajeDto) throws RuntimeException;
    void update(EquipajeDto equipajeDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    EquipajeDto findById(int id) throws RuntimeException;
    List<EquipajeDto> findAll() throws RuntimeException;
}
