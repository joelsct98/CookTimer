package com.example.proyecto_final_1.Administrador;

import android.content.ContentValues;
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

public class modificar_administrador extends AppCompatActivity {
    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_administrador);

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

            Toast.makeText(this, "No existe un empleado en este codigo", Toast.LENGTH_SHORT).show();
        }
        bd.close();

    }

    public void modificaradministrador(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String usuario=et1.getText().toString();
        String contrasennaAdmin=et2.getText().toString();
        String cargo=et3.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre",usuario);
        registro.put("contraseña",contrasennaAdmin);
        registro.put("cargo",cargo);
        int cant=bd.update("administradores",registro,"nombre='"+usuario+"'",null);
        bd.close();
        if(cant==1){
            et1.setText("");
            et2.setText("");
            et3.setText("");

            Toast.makeText(this, "Se modificaron los datos del administrador: "+usuario, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "No se modificaron los datos correctamente", Toast.LENGTH_SHORT).show();
        et1.setText("");
        et2.setText("");
        et3.setText("");


        Intent i=new Intent(this, administradores.class);
        startActivity(i);
    }

    public void cancelar(View view){
        Intent i=new Intent(this, administradores.class);
        startActivity(i);
    }
}
