package com.estudio.reservas.dominio.entidades;

import java.time.LocalDateTime;

public class TipoPago {

    private int id;
    private String medio_pago;
    private String usuario_modificado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String tipo_moneda) {
        this.medio_pago = tipo_moneda;
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

