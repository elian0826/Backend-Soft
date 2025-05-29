package com.estudio.reservas.dto;

import java.io.Serializable;

public class GetMaestras implements Serializable {

    private String nombre;

    public GetMaestras() {}

    public GetMaestras(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
