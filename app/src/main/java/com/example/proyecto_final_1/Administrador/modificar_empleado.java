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

public class modificar_empleado extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_empleado);

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

    public void modificarempleado(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String nombre=et1.getText().toString();
        String apellido=et2.getText().toString();
        String cod_empleado=et3.getText().toString();
        String contrasenna=et4.getText().toString();
        String puesto=et5.getText().toString();
        String turno=et6.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("apellidos",apellido);
        registro.put("cod_empleado",cod_empleado);
        registro.put("contraseña",contrasenna);
        registro.put("puesto",puesto);
        registro.put("turno",turno);
        int cant=bd.update("empleados",registro,"cod_empleado='"+cod_empleado+"'",null);
        bd.close();
        if(cant==1){
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");
            et6.setText("");
            Toast.makeText(this, "Se modificaron los datos del empleado: "+cod_empleado, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "No se modificaron los datos correctamente", Toast.LENGTH_SHORT).show();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");

        Intent i=new Intent(this,usuarios.class);
        startActivity(i);
    }

    public void cancelar(View view){
        Intent i=new Intent(this, usuarios.class);
        startActivity(i);
    }
}
