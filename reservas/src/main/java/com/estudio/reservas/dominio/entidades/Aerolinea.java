package com.estudio.reservas.dominio.entidades;


import java.time.LocalDateTime;

public class Aerolinea {
    private int id;
    private String nombre;
    private String usuario_modificado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarioModificado() {
        return usuario_modificado;
    }

    public void setUsuarioModificado(String usuario_modificado) {
        this.usuario_modificado = usuario_modificado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}


