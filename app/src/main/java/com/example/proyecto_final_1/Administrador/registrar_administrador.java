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

public class registrar_administrador extends AppCompatActivity {

    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_administrador);

        et1=findViewById(R.id.Usuario);
        et2=findViewById(R.id.contrasennaAdmin);
        et3=findViewById(R.id.cargo);

    }

    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String usuario=et1.getText().toString();
        String contrasennaAdmin=et2.getText().toString();
        String cargo=et3.getText().toString();


        ContentValues registro = new ContentValues();
        registro.put("nombre",usuario);
        registro.put("contraseña",contrasennaAdmin);
        registro.put("cargo",cargo);

        bd.insert("administradores",null,registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");

        Toast.makeText(this, "Administrador creado correctamente",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this, administradores.class);
        startActivity(i);
    }

    public void cancelar(View view){
        Intent i=new Intent(this, administradores.class);
        startActivity(i);
    }
}