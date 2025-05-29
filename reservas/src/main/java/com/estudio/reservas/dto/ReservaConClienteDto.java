package com.estudio.reservas.dto;

public class ReservaConClienteDto {

    private ClientesDto cliente;
    private ReservaDto reserva;

    public ClientesDto getCliente() {
        return cliente;
    }

    public void setCliente(ClientesDto cliente) {
        this.cliente = cliente;
    }

    public ReservaDto getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDto reserva) {
        this.reserva = reserva;
    }
}
