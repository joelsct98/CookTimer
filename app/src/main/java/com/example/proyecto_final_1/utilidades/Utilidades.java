package com.example.proyecto_final_1.utilidades;

import java.io.Serializable;

public class Utilidades implements Serializable {


    //Constantes campos tabla articulos
    public static String usuarios = "usuarios";
    public static String avatar = "avatar";
    public static String contraseña = "contraseña";
    public static String puesto = "puesto";


    public static final String usuario= "CREATE TABLE "
            +usuarios+" ("
            +avatar+" TEXT PRIMARY KEY , "
            +contraseña+" TEXT , "
            +puesto+" TEXT )";


    public static String Producto = "Productos";
    public static String Nombre = "Nombre";
    public static String Precio = "Precio";
    public static String tipo = "tipo";
    public static String Stock = "Stock";

    public static final String Productos= "CREATE TABLE "
            +Producto+" ("
            +Nombre+" TEXT , "
            +Precio+"  INTEGER, "
            +tipo+" TEXT  , "
            +Stock+" INTEGER )";


    public static String administradoresA = "administradores";
    public static String nombre = "nombre";
    public static String contraseñaA = "contraseña";
    public static String cargo = "cargo";

    public static final String administradores= "CREATE TABLE "
            +administradoresA+" ("
            +nombre+" TEXT PRIMARY KEY, "
            +contraseñaA+" TEXT, "
            +cargo+" TEXT )";


}
