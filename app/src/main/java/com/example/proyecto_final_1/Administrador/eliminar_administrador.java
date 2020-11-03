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

public class eliminar_administrador extends AppCompatActivity {
    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_administrador);

        et1=findViewById(R.id.usuario);
        et2=findViewById(R.id.contrasennaAdmin);
        et3=findViewById(R.id.cargo);
    }

    public void consultaporcodigoadministrador(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String usuario =et1.getText().toString();

        Cursor fila = bd.rawQuery(
                "select contraseña, cargo from administradores where nombre='" + usuario + "'", null);

        if(fila.moveToFirst()){
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));

        }else {
            et2.setText("");
            et3.setText("");

            Toast.makeText(this, "No existe un administrador en este usuario", Toast.LENGTH_SHORT).show();
        }
        bd.close();

    }

    public void bajadministrador(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String usuario =et1.getText().toString();
        int cant=bd.delete("administradores","nombre='"+usuario+"'",null);
        bd.close();
        if(cant==1) {
            et1.setText("");
            et2.setText("");
            et3.setText("");

            Toast.makeText(this, "Se borró el administrador con el usuario: "+usuario, Toast.LENGTH_SHORT).show();
            Intent u=new Intent(this, administradores.class);
            startActivity(u);
        }else
            Toast.makeText(this, "No exiaste un administrador con dicho nombre", Toast.LENGTH_SHORT).show();
    }

    public void cancelar(View view){
        Intent i=new Intent(this, administradores.class);
        startActivity(i);
    }
}
