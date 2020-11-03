package com.example.proyecto_final_1.entidades;

import java.io.Serializable;

public class Pedidos implements Serializable {


    private String numMesa;
    private String precioTotal;
    private String activo;

    public Pedidos() {
    }

    public Pedidos(String numMesa, String precioTotal, String platos, String activo) {
        this.numMesa = numMesa;
        this.precioTotal = precioTotal;
        this.activo = activo;
    }

    public String getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(String numMesa) {
        this.numMesa = numMesa;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
