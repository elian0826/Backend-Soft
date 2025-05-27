package com.estudio.reservas.dto;

import java.math.BigDecimal;

public class EquipajeDto {
    private Long id;
    private String tipo_equipaje;
    private BigDecimal peso;
    private BigDecimal precio;
    private Long moneda_id;
    private Long reserva_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_equipaje() {
        return tipo_equipaje;
    }

    public void setTipo_equipaje(String tipo_equipaje) {
        this.tipo_equipaje = tipo_equipaje;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Long getMoneda_id() {
        return moneda_id;
    }

    public void setMoneda_id(Long moneda_id) {
        this.moneda_id = moneda_id;
    }

    public Long getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(Long reserva_id) {
        this.reserva_id = reserva_id;
    }


}
