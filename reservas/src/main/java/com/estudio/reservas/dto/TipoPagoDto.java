package com.estudio.reservas.dto;

public class TipoPagoDto {
    private Long id;
    private String medio_pago;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }
}
