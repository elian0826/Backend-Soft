package com.estudio.reservas.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Equipaje {

    private int id;
    private String tipo_equipaje;
    private BigDecimal peso;
    private BigDecimal precio;
    private int moneda_id;
    private int reserva_id;
    private String usuario_modificado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getMoneda_id() {
        return moneda_id;
    }

    public void setMoneda_id(int moneda_id) {
        this.moneda_id = moneda_id;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
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