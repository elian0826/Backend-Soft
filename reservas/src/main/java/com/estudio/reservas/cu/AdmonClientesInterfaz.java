package com.estudio.reservas.cu;

import com.estudio.reservas.dto.ClientesDto;
import java.util.List;

public interface AdmonClientesInterfaz {
    void insert(ClientesDto clientesDto) throws RuntimeException;
    void update(ClientesDto clientesDto) throws RuntimeException;
    void delete(int id) throws RuntimeException;
    ClientesDto findById(int id) throws RuntimeException;
    List<ClientesDto> findAll() throws RuntimeException;
    ClientesDto findByDocumento(int documento) throws RuntimeException;

}
