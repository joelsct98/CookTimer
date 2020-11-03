package com.example.proyecto_final_1.Administrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.R;

public class registrar_producto extends AppCompatActivity {
    private EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);

        et1=findViewById(R.id.nombreProducto);
        et2=findViewById(R.id.precioProducto);
        et3=findViewById(R.id.stock);
        et4=findViewById(R.id.tipo);
    }

    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String nombre=et1.getText().toString();
        String precio=et2.getText().toString();
        String stock=et3.getText().toString();
        String tipo=et4.getText().toString();


        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("precio",precio);
        registro.put("stock",stock);
        registro.put("tipo",tipo);

        bd.insert("productos",null,registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Producto añadido correctamente",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,productos.class);
        startActivity(i);
    }

    public void cancelar(View view){
        Intent i=new Intent(this, productos.class);
        startActivity(i);
    }
}
