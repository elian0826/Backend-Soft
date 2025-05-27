package com.estudio.reservas.cu;

import com.estudio.reservas.dto.TipoPagoDto;

import java.util.List;

public interface AdmonTipoPagoInterfaz {
    void insert(TipoPagoDto tipoPagoDto) throws RuntimeException;
    void update(TipoPagoDto tipoPagoDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    TipoPagoDto findById(int id) throws RuntimeException;
    List<TipoPagoDto> findAll() throws RuntimeException;
}
