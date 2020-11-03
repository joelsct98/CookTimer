package com.example.proyecto_final_1.MENU;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.proyecto_final_1.Adaptadores.AdaptadorProductos;
import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.R;
import com.example.proyecto_final_1.entidades.Productos;

import java.util.ArrayList;

public class TodosMenus2 extends AppCompatActivity {

    ArrayList<Productos> listaPlatos;
    RecyclerView recyclerViewPlatos;
    AdminSQLiteOpenHelper conn;
    String valor="";
    String nombre="";
    String mesa="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            SharedPreferences preferences=getSharedPreferences("datos", MODE_PRIVATE) ;
            String val=preferences.getString("valor","no hay datos");
            mesa = val;
            valor = extras.getString("tipo");
        }


        conn = new AdminSQLiteOpenHelper(getApplicationContext());
        listaPlatos= new ArrayList<>();
        recyclerViewPlatos = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerViewPlatos.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        AdaptadorProductos adapter=new AdaptadorProductos(listaPlatos);
        recyclerViewPlatos.setAdapter(adapter);

        //para probar
        //Toast.makeText(this,mesa,Toast.LENGTH_LONG).show();

        adapter.enviarDatos(mesa);
    }
    private void consultarListaPersonas(){
        SQLiteDatabase db=conn.getReadableDatabase();

        Productos productos=null;

        Cursor cursor = db.rawQuery("select Nombre,Precio,Stock from Productos where tipo='"+valor+"'",null);
        while(cursor.moveToNext()){
            productos=new Productos();
            productos.setNombre(cursor.getString(0));
            productos.setPrecio(cursor.getString(1));
            productos.setStock(cursor.getString(2));
            listaPlatos.add(productos);
        }
    }

}