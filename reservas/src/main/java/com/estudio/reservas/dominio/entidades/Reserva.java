package com.estudio.reservas.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reserva {

    private int id;
    private int numero_vuelos;
    private BigDecimal valor;
    private LocalDate fecha_vuelos;
    private LocalTime hora;
    private BigDecimal valor_equipaje;
    private int cliente_id;
    private int aerolinea_id;
    private int moneda_id;
    private int tipo_pago_id;
    private int origen_id;
    private int destino_id;
    private String usuario_modificado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_vuelos() {
        return numero_vuelos;
    }

    public void setNumero_vuelos(int numero_vuelos) {
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

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getAerolinea_id() {
        return aerolinea_id;
    }

    public void setAerolinea_id(int aerolinea_id) {
        this.aerolinea_id = aerolinea_id;
    }

    public int getMoneda_id() {
        return moneda_id;
    }

    public void setMoneda_id(int moneda_id) {
        this.moneda_id = moneda_id;
    }

    public int getTipo_pago_id() {
        return tipo_pago_id;
    }

    public void setTipo_pago_id(int tipo_pago_id) {
        this.tipo_pago_id = tipo_pago_id;
    }

    public int getOrigen_id() {
        return origen_id;
    }

    public void setOrigen_id(int origen_id) {
        this.origen_id = origen_id;
    }

    public int getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(int destino_id) {
        this.destino_id = destino_id;
    }

    public String getUsuario_modificado() {
        return usuario_modificado;
    }

    public void setUsuario_modificado(String usuario_modificado) {
        this.usuario_modificado = usuario_modificado;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
