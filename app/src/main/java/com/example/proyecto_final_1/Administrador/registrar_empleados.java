package com.example.proyecto_final_1.Administrador;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.R;

public class registrar_empleados extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empleados);

        et1=findViewById(R.id.nombre);
        et2=findViewById(R.id.apellido);
        et3=findViewById(R.id.cod_empleado);
        et4=findViewById(R.id.contraseña);
        et5=findViewById(R.id.puesto);
        et6=findViewById(R.id.turno);

    }

    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String nombre=et1.getText().toString();
        String apellido=et2.getText().toString();
        String cod_empleado=et3.getText().toString();
        String contrasenna=et4.getText().toString();
        String puesto=et5.getText().toString().toLowerCase();
        String turno=et6.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("apellidos",apellido);
        registro.put("cod_empleado",cod_empleado);
        registro.put("contraseña",contrasenna);
        registro.put("puesto",puesto);
        registro.put("turno",turno);
        bd.insert("empleados",null,registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        Toast.makeText(this, "Empleado creado correctamente",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,usuarios.class);
        startActivity(i);
    }

    public void cancelar(View view){
        Intent i=new Intent(this, usuarios.class);
        startActivity(i);
    }

}