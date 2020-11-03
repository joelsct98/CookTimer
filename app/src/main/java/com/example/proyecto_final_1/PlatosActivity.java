package com.example.proyecto_final_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.proyecto_final_1.Adaptadores.AdaptadorPedidosDentro;
import com.example.proyecto_final_1.entidades.PedidosDentro;
import com.example.proyecto_final_1.entidades.Productos;

import java.util.ArrayList;

public class PlatosActivity extends AppCompatActivity {

    ArrayList<PedidosDentro> listaPlatos;
    RecyclerView recyclerViewPlatos;
    AdminSQLiteOpenHelper conn;
    String valor="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            valor = extras.getString("mesa");
        }

        conn = new AdminSQLiteOpenHelper(getApplicationContext());
        listaPlatos= new ArrayList<>();
        recyclerViewPlatos = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerViewPlatos.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        AdaptadorPedidosDentro adapter=new AdaptadorPedidosDentro(listaPlatos);
        recyclerViewPlatos.setAdapter(adapter);
/*
        TextView IdMesa =(TextView) findViewById(R.id.IdMesa);
        IdMesa.setText(valor);
*/
    }

    private void consultarListaPersonas(){
        SQLiteDatabase db=conn.getReadableDatabase();

        PedidosDentro productos=null;

        Cursor cursor = db.rawQuery("select nombre,cantidad from pedidosProductos where numMesa='"+valor+"'",null);
        while(cursor.moveToNext()){
            productos=new PedidosDentro();
            productos.setNombreP(cursor.getString(0));
            productos.setCantidad(cursor.getString(1));
            listaPlatos.add(productos);
        }
    }
}