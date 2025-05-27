package com.estudio.reservas.dto;

public class MonedaDto {
    private Long id;
    private String tipo_moneda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(String tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }
}
