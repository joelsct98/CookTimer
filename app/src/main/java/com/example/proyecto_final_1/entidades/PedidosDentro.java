package com.example.proyecto_final_1.entidades;

import java.io.Serializable;

public class PedidosDentro implements Serializable {

    private String NombreP;
    private String cantidad;

    public PedidosDentro() {
    }

    public PedidosDentro(String nombreP, String cantidad) {
        NombreP = nombreP;
        cantidad=cantidad;
    }

    public String getNombreP() {
        return NombreP;
    }

    public void setNombreP(String nombreP) {
        NombreP = nombreP;
    }
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}
