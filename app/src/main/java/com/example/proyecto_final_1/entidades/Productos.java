package com.example.proyecto_final_1.entidades;

import java.io.Serializable;

public class Productos implements Serializable{

    private String Nombre;
    private String Precio;
    private String Stock;
    private String Tipo;

    public Productos(){
    }

    public Productos(String nombre, String precio, String stock, String tipo) {
        Nombre = nombre;
        Precio = precio;
        Stock = stock;
        Tipo = tipo;
    }

    public Productos(String nombre, String precio, String stock) {
        Nombre = nombre;
        Precio = precio;
        Stock = stock;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}