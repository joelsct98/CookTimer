package com.example.proyecto_final_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import com.example.proyecto_final_1.Administrador.eliminar_producto;
import com.example.proyecto_final_1.Administrador.modificar_producto;
import com.example.proyecto_final_1.Administrador.registrar_producto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.proyecto_final_1.ui.main.SectionsPagerAdapter;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }

    public void content(){
        refresh(10000);
        Intent a=new Intent(this, Main3Activity.class);
        startActivity(a);
    }



    private  void refresh(int milliseconds){
        final Handler handler= new Handler();

        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3, menu);
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cerrarSesion:
                String valor="";
                SharedPreferences datos= getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor miEditor=datos.edit();
                miEditor.putString("valor", valor);
                miEditor.apply();
                Intent i=new Intent(this, MainActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
            case R.id.refrescar:

               String valor2="";
                SharedPreferences datos2= getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor miEditor2=datos2.edit();
                miEditor2.putString("valor", valor2);
                miEditor2.apply();
                Intent a=new Intent(this, Main3Activity.class);
                startActivity(a);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}