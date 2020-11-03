package com.example.proyecto_final_1.Administrador;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_final_1.MainActivity;
import com.example.proyecto_final_1.R;

public class registros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
    }

    public void usuarios(View view){
        Intent i=new Intent(this, usuarios.class);
        startActivity(i);
    }
    public void productos(View view){
        Intent i=new Intent(this, productos.class);
        startActivity(i);
    }
    public void administradores (View view){
        Intent i=new Intent(this, administradores.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cerrarSesion:
                Intent i=new Intent(this, MainActivity.class);
                startActivity(i);
                finishAffinity();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
