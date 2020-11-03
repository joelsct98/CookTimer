package com.example.proyecto_final_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyecto_final_1.Adaptadores.AdaptadorProductos;
import com.example.proyecto_final_1.utilidades.Utilidades;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String name = "AdminSQLiteOpenHelper";

    public AdminSQLiteOpenHelper(Context context) {
        super(context, name, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.administradores);
        //insert administradores
        db.execSQL("INSERT INTO administradores VALUES ('admin','admin','RRCC')");


        //insert empleados
        db.execSQL("create table empleados (nombre text, apellidos text, cod_empleado text,contraseña text,puesto text, turno text)");
        db.execSQL("INSERT INTO empleados VALUES ('Joel Sebastian','Chavez Tenorio','Joel1022','joel','camarero','mañana')");
        db.execSQL("INSERT INTO empleados VALUES ('Oscar Eduardo','Founes Jorgge','Oscar0124','oscar24','camarero','mañana')");
        db.execSQL("INSERT INTO empleados VALUES ('Leonela','Founes Jorgge','Leonela0820','leito','cocinera','tarde')");


        db.execSQL("create table productos (nombre text, precio text, stock text, tipo text)");
        //BEBIDAS
        db.execSQL("INSERT INTO productos VALUES ('cerveza 1/3','1','100','bebidas')");
        db.execSQL("INSERT INTO productos VALUES ('jarra cerveza 1/2','1.5','100','bebidas')");
        db.execSQL("INSERT INTO productos VALUES ('botellin mahou','1.55','100','bebidas')");
        db.execSQL("INSERT INTO productos VALUES ('botellin heineken','1.6','100','bebidas')");
        db.execSQL("INSERT INTO productos VALUES ('vino tinto','1.70','100','bebidas')");
        db.execSQL("INSERT INTO productos VALUES ('botella agua 1/2','1','100','bebidas')");
        db.execSQL("INSERT INTO productos VALUES ('chicha morada','1.8','100','bebidas')");
        //PRIMER PLATO
        db.execSQL("INSERT INTO productos VALUES ('lentejas','4.5','100','primerPlato')");
        db.execSQL("INSERT INTO productos VALUES ('patatas guisadas con costillas','5','100','primerPlato')");
        db.execSQL("INSERT INTO productos VALUES ('patatas guisadas con níscalos','5','100','primerPlato')");
        db.execSQL("INSERT INTO productos VALUES ('patatas guisadas con calamares','5','100','primerPlato')");
        db.execSQL("INSERT INTO productos VALUES ('cocido madrileño','6','100','primerPlato')");
        db.execSQL("INSERT INTO productos VALUES ('fabada australiana','6','100','primerPlato')");

        //ensaladas
        db.execSQL("INSERT INTO productos VALUES ('ensalada campera','1','100','ensalada')");
        db.execSQL("INSERT INTO productos VALUES ('ensalada mixta','1.5','100','ensalada')");
        db.execSQL("INSERT INTO productos VALUES ('ensalada cesar','2.5','100','ensalada')");
        db.execSQL("INSERT INTO productos VALUES ('ensalada pavo','1.25','100','ensalada')");
        db.execSQL("INSERT INTO productos VALUES ('ensalada marisco','2','100','segundoPlato')");

        //SEGUNDO PLATO
        db.execSQL("INSERT INTO productos VALUES ('entrecot a la plancha','7','100','segundoPlato')");
        db.execSQL("INSERT INTO productos VALUES ('rabo de toro','6.5','100','segundoPlato')");
        db.execSQL("INSERT INTO productos VALUES ('pollo a la plancha','6.5','100','segundoPlato')");
        db.execSQL("INSERT INTO productos VALUES ('chuleta de cordero','6.5','100','segundoPlato')");
        db.execSQL("INSERT INTO productos VALUES ('chuleta de cerdo','6.5','100','segundoPlato')");
        db.execSQL("INSERT INTO productos VALUES ('lubina a la plancha','8','100','segundoPlato')");
        db.execSQL("INSERT INTO productos VALUES ('pescadilla a la romana','8','100','segundoPlato')");
        //postres
        db.execSQL("INSERT INTO productos VALUES ('flan con nata','1','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('natilla de vainilla','1.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('yogurt','1.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado grande fresa','5','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado grande arandano','5','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado grande maracuya','5','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado grande mango','5','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado mediano fresa','3.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado mediano arandano','3.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado mediano maracuya','3.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado mediano mango','3.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado pequeño fresa','3.25','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado pequeño arandano','1.75','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado pequeño maracuya','1.75','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('helado pequeño mango','1.75','100','postres')");
        db.execSQL("INSERT INTO productos VALUES ('melon','1.5','100','postres')");
        //raciones
        db.execSQL("INSERT INTO productos VALUES ('tortilla española (trozo)','1.5','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('paella mixta','3.5','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('pulpo a la gallega','4','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('toreznos','1.5','3','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('jamon iberico','1.5','3','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('oreja a la plancha','3','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('patatas','1.5','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('boquerones','2.5','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('croquetas de jamon','2','100','raciones')");
        db.execSQL("INSERT INTO productos VALUES ('croquetas de bacalao','2','100','raciones')");
        //PLATOS DE LA CASA
        db.execSQL("INSERT INTO productos VALUES ('tallarin verde','3','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('ceviche','5','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('pollo a la brasa','6','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('pollo 1/4','5','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('pollo 1/2','','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('pollo entero','1.5','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('monstrito','1.5','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('arroz con pollo','5','100','platosCasa')");
        db.execSQL("INSERT INTO productos VALUES ('papa a la huancaina','4.5','100','platosCasa')");
        //extras
        db.execSQL("INSERT INTO productos VALUES ('pan','1','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('patatas fritas','1.75','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('patatas bravas','1.8','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('arroz (pequeño)','1.5','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('arroz (grande)','2.5','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('wantan frito','1.5','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('alitas de pollo 6uds','3.95','100','entrantes')");
        db.execSQL("INSERT INTO productos VALUES ('alitas de pollo 11uds','5.55','100','entrantes')");
        //OFERTAS
        db.execSQL("INSERT INTO productos VALUES ('macarrones con carne','1','100','ofertas')");
        db.execSQL("INSERT INTO productos VALUES ('esparragos con mahonesa','1','100','ofertas')");
        db.execSQL("INSERT INTO productos VALUES ('pimientos de piquillos relleno','1','100','ofertas')");
        db.execSQL("INSERT INTO productos VALUES ('paella de pollo','1','100','ofertas')");
        db.execSQL("INSERT INTO productos VALUES ('gazpacho','1','100','ofertas')");
        db.execSQL("INSERT INTO productos VALUES ('salmorejo','1','100','ofertas')");
        //cocteles
        db.execSQL("INSERT INTO productos VALUES ('bloody mary','7','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('mojito','5','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('tequila sunrise','6','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('tom collins','5','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('clericot','7','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('rebujito','5','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('agua valencia','5','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('cafe irlandes','7','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('vieux carre','6','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('mimosa frambuesa','6','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('dry martini','5','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('margarita','5','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('singapore sling','7','100','cocteles')");
        db.execSQL("INSERT INTO productos VALUES ('negroni','6','100','cocteles')");

        //diseño de fuera
        db.execSQL("create table pedidos (numMesa text,precioTotal text, activo text)");
        db.execSQL("INSERT INTO pedidos VALUES ('1','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('2','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('3','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('4','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('5','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('6','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('7','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('8','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('9','0','1')");
        db.execSQL("INSERT INTO pedidos VALUES ('10','0','1')");

        //recycler listado
        db.execSQL("create table pedidosProductos (nombre text,numMesa text,cantidad text)");


        //vamo a probar como funciona la tabla poniendole valores separados
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
