package com.example.proyecto_final_1.Administrador;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.R;

public class eliminar_empleado extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_empleado);

        et1=findViewById(R.id.nombre);
        et2=findViewById(R.id.apellido);
        et3=findViewById(R.id.cod_empleado);
        et4=findViewById(R.id.contraseña);
        et5=findViewById(R.id.puesto);
        et6=findViewById(R.id.turno);
    }

    public void consultaporcodigoempleado(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String codempleado =et3.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre, apellidos, contraseña, puesto, turno from empleados where cod_empleado='" + codempleado + "'", null);

        if(fila.moveToFirst()){
            et1.setText(fila.getString(0));
            et2.setText(fila.getString(1));
            et4.setText(fila.getString(2));
            et5.setText(fila.getString(3));
            et6.setText(fila.getString(4));
        }else {
            et1.setText("");
            et2.setText("");
            et4.setText("");
            et5.setText("");
            et6.setText("");
            Toast.makeText(this, "No existe un empleado en este codigo", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }


    public void bajaempleado(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String cod_empleado=et3.getText().toString();
        int cant=bd.delete("empleados","cod_empleado='"+cod_empleado+"'",null);
        bd.close();
        if(cant==1) {
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");
            et6.setText("");
            Toast.makeText(this, "Se borró el empleado con el codigo: "+cod_empleado, Toast.LENGTH_SHORT).show();
            Intent u=new Intent(this, usuarios.class);
            startActivity(u);
        }else
            Toast.makeText(this, "No exiaste un empleado con dicho código", Toast.LENGTH_SHORT).show();
    }

    public void cancelar(View view){
        Intent i=new Intent(this, usuarios.class);
        startActivity(i);
    }
}
