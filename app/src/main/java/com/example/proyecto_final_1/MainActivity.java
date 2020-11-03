package com.example.proyecto_final_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_final_1.Administrador.registros;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);


    }



    public void validar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String pwT="";
        String usuarioPW="";
        String usuario = et1.getText().toString();
        String pw = et2.getText().toString();


        if(!usuario.equals("") || !pw.equals("")){
            Cursor fila= bd.rawQuery(
                    "select contraseña, puesto from empleados where cod_empleado='"+usuario+"'", null);

            if(fila.moveToFirst()){
                usuarioPW = fila.getString(0);
                if(!fila.getString(1).equals("cocinero") && !fila.getString(1).equals("cocinera")){
                    if(pw.equals(usuarioPW)){
                        Intent i = new Intent(this, Main3Activity.class);
                        startActivity(i);

                    }else {
                        Toast.makeText(this, "La contraseña es incorrecta",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if(pw.equals(usuarioPW)){
                        Intent i = new Intent(this, cocina.class);
                        startActivity(i);

                    }else {
                        Toast.makeText(this, "La contraseña es incorrecta",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            Cursor administrador= bd.rawQuery(
                    "select contraseña, cargo from administradores where nombre='"+usuario+"'", null);

            if(administrador.moveToFirst()){
                pwT = administrador.getString(0);
                if(pw.equals(pwT)){
                    Intent i = new Intent(this, registros.class);
                    startActivity(i);

                }else {
                    Toast.makeText(this, "El usuario o contraseña son incorrectas",
                            Toast.LENGTH_SHORT).show();
                }

            }

            if(pwT.equals("") && usuarioPW.equals("")){
                Toast.makeText(this, "Usuario no encontrado",
                        Toast.LENGTH_SHORT).show();
            }




            bd.close();
        }else {
            Toast.makeText(this, "Rellene los campos por favor",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
