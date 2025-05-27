package com.estudio.reservas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDto {

    private Long id;
    private Integer numero_vuelos;
    private BigDecimal valor;
    private LocalDate fecha_vuelos;
    private LocalTime hora;
    private BigDecimal valor_equipaje;

    private Long cliente_id;
    private Long aerolinea_id;
    private Long moneda_id;
    private Long tipo_pago_id;
    private Long origen_id;
    private Long destino_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero_vuelos() {
        return numero_vuelos;
    }

    public void setNumero_vuelos(Integer numero_vuelos) {
        this.numero_vuelos = numero_vuelos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getFecha_vuelos() {
        return fecha_vuelos;
    }

    public void setFecha_vuelos(LocalDate fecha_vuelos) {
        this.fecha_vuelos = fecha_vuelos;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public BigDecimal getValor_equipaje() {
        return valor_equipaje;
    }

    public void setValor_equipaje(BigDecimal valor_equipaje) {
        this.valor_equipaje = valor_equipaje;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Long getAerolinea_id() {
        return aerolinea_id;
    }

    public void setAerolinea_id(Long aerolinea_id) {
        this.aerolinea_id = aerolinea_id;
    }

    public Long getMoneda_id() {
        return moneda_id;
    }

    public void setMoneda_id(Long moneda_id) {
        this.moneda_id = moneda_id;
    }

    public Long getTipo_pago_id() {
        return tipo_pago_id;
    }

    public void setTipo_pago_id(Long tipo_pago_id) {
        this.tipo_pago_id = tipo_pago_id;
    }

    public Long getOrigen_id() {
        return origen_id;
    }

    public void setOrigen_id(Long origen_id) {
        this.origen_id = origen_id;
    }

    public Long getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(Long destino_id) {
        this.destino_id = destino_id;
    }
}
