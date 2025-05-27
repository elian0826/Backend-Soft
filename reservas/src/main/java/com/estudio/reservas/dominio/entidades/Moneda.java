package com.estudio.reservas.dominio.entidades;

import java.time.LocalDateTime;

public class Moneda {
    private int id;
    private String tipo_moneda;
    private String usuario_modificado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(String tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
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
