package com.example.proyecto_final_1;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_1.Adaptadores.AdaptadorPedidos;
import com.example.proyecto_final_1.entidades.Pedidos;

import java.util.ArrayList;


public class ModificarFragment extends Fragment {
    RecyclerView recyclerPedidos;
    ArrayList<Pedidos> listaPedidos;
    AdminSQLiteOpenHelper conn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_modificar, container, false);

        listaPedidos=new ArrayList<>();
        recyclerPedidos=(RecyclerView)vista.findViewById(R.id.recyclerId);
        recyclerPedidos.setLayoutManager(new LinearLayoutManager(getContext()));

        consultarListaPersonas(vista);

        AdaptadorPedidos adapter= new AdaptadorPedidos(listaPedidos);
        recyclerPedidos.setAdapter(adapter);

        return vista;
    }
    private void consultarListaPersonas(View view){
        Activity activity = getActivity();
        recyclerPedidos = view.findViewById(R.id.recyclerId);
        conn = new AdminSQLiteOpenHelper(getActivity());

        SQLiteDatabase db=conn.getReadableDatabase();

        Pedidos pedidos=null;

        Cursor cursor = db.rawQuery("select numMesa,precioTotal,activo from pedidos",null);
        while(cursor.moveToNext()){
            pedidos=new Pedidos();
            pedidos.setNumMesa(cursor.getString(0));
            pedidos.setPrecioTotal(cursor.getString(1));
            pedidos.setActivo(cursor.getString(2));
            listaPedidos.add(pedidos);
        }
    }
}