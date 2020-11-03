package com.example.proyecto_final_1.Administrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.R;

public class modificar_producto extends AppCompatActivity {
    private EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_producto);

        et1=findViewById(R.id.nombreProducto);
        et2=findViewById(R.id.precioProducto);
        et3=findViewById(R.id.stock);
        et4=findViewById(R.id.tipo);

    }

    public void consultapornombreproducto(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String nombre =et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select precio, stock, tipo from productos where nombre='" + nombre + "'", null);

        if(fila.moveToFirst()){
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));

        }else {
            et2.setText("");
            et3.setText("");
            et4.setText("");
            Toast.makeText(this, "No existe un producto en este nombre", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void modificarproducto(View v){
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
        int cant=bd.update("productos",registro,"nombre='"+nombre+"'",null);
        bd.close();
        if(cant==1){
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");

            Toast.makeText(this, "Se modificaron los datos del producto: "+nombre, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "No se modificaron los datos correctamente", Toast.LENGTH_SHORT).show();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");


        Intent i=new Intent(this,productos.class);
        startActivity(i);
    }

    public void cancelar(View view){
        Intent i=new Intent(this, productos.class);
        startActivity(i);
    }
}
