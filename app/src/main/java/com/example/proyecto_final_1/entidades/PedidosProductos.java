package com.example.proyecto_final_1.entidades;

import java.io.Serializable;

public class PedidosProductos implements Serializable {
    private String nombre;
    private String cantidad;

    public PedidosProductos() {
    }

    public PedidosProductos(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
