package com.example.proyecto_final_1.Adaptadores;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.MENU.TodosMenus2;
import com.example.proyecto_final_1.R;
import com.example.proyecto_final_1.entidades.PedidosDentro;
import com.example.proyecto_final_1.entidades.Productos;

import java.util.ArrayList;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ViewHolderPersonajes> {
    ArrayList<Productos> listaUsuario;
    AdminSQLiteOpenHelper conn;
    String mesada;

    public void enviarDatos(String mesa) {
        // Actualizas los valores de las variables
        this.mesada = mesa;
    }
    public AdaptadorProductos(ArrayList<Productos> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView etiNombre, Etiprecio,etiStock;
        ImageButton menos,mas;
        Context context;
        String mesa;


        public ViewHolderPersonajes(View itemView) {
            super(itemView);
            etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
            Etiprecio=(TextView) itemView.findViewById(R.id.idPrecio);
            etiStock=(TextView) itemView.findViewById(R.id.idStock);
            mas=(ImageButton) itemView.findViewById(R.id.btnMas);
            menos=(ImageButton) itemView.findViewById(R.id.btnMenos);
            context=itemView.getContext();
            mesa=mesada;
        }
        void setOnClickListener(AdaptadorProductos adaptadorPedidos){
            mas.setOnClickListener(this);
            menos.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //para los botones del menu
            switch (v.getId()){
                case R.id.btnMas:
                    Intent i = new Intent(context, TodosMenus2.class);
                    i.putExtra("mombrePlato",etiNombre.getText());
                    Etiprecio.getText();
                    String mesadora=mesa.toString();
                    String nombre=etiNombre.getText().toString();
                    String precio=Etiprecio.getText().toString();

                    conn = new AdminSQLiteOpenHelper(context);
                    SQLiteDatabase bd=conn.getWritableDatabase();

                    Cursor cursor = bd.rawQuery("select cantidad from pedidosProductos where nombre='"+nombre+"'and numMesa='"+mesadora+"'",null);
                    String cant="";

                    if (cursor.moveToNext()) {
                        cant=cursor.getString(0);
                        int numEntero = Integer.parseInt(cant);
                        numEntero=numEntero+1;
                        cant=String.valueOf(numEntero);
                        //Toast.makeText(context,cant,Toast.LENGTH_LONG).show();
                        bd.execSQL("UPDATE pedidosProductos SET cantidad='"+cant+"' where nombre='"+nombre+"'and numMesa='"+mesadora+"'");
                    }else{
                        bd.execSQL("INSERT INTO pedidosProductos VALUES ('"+nombre+"','"+mesadora+"','1')");
                        Toast.makeText(context,"creado",Toast.LENGTH_LONG).show();
                    }


                    Cursor cursorPedidos = bd.rawQuery("select precioTotal from pedidos where numMesa='"+mesadora+"'",null);
                    Cursor cursorProductos = bd.rawQuery("select precio from productos where nombre='"+nombre+"'",null);
                    String precioPedidos="";
                    String precioProductos="";

                    if (cursorProductos.moveToNext()) {
                        precioProductos=cursorProductos.getString(0);
                        if (cursorPedidos.moveToNext()) {

                            precioPedidos=cursorPedidos.getString(0);
                            double numEnteroPedidos = Double.parseDouble(precioPedidos);
                            double numEnteroProductos= Double.parseDouble(precioProductos);
                            numEnteroPedidos=numEnteroPedidos+numEnteroProductos;
                            precioPedidos=String.valueOf(numEnteroPedidos);

                            //Toast.makeText(context,precioPedidos,Toast.LENGTH_LONG).show();
                            bd.execSQL("UPDATE pedidos SET precioTotal='"+precioPedidos+"' where numMesa='"+mesadora+"'");
                        }else{
                            Toast.makeText(context,"Introduzca la mesa",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(context,"fallo productos",Toast.LENGTH_LONG).show();
                    }
                    /**/

                    bd.close();

                    break;
                case R.id.btnMenos:
                    String Nummesadora=mesa.toString();
                    String nombrePlato=etiNombre.getText().toString();

                    conn = new AdminSQLiteOpenHelper(context);

                    SQLiteDatabase bd4=conn.getWritableDatabase();
                    Cursor cursor2 = bd4.rawQuery("select cantidad from pedidosProductos where nombre='"+nombrePlato+"'and numMesa='"+Nummesadora+"'",null);
                    String cant2="";


                    if (cursor2.moveToNext()) {
                        cant2=cursor2.getString(0);
                        if (cant2.equals("0")){
                            cant2=cursor2.getString(0);
                            bd4.execSQL("DELETE FROM pedidosProductos WHERE nombre='"+nombrePlato+"'and numMesa='"+Nummesadora+"'");
                            Toast.makeText(context,"eliminado",Toast.LENGTH_LONG).show();
                        }else{
                            int numEntero = Integer.parseInt(cant2);
                            numEntero=numEntero-1;
                            cant2=String.valueOf(numEntero);
                            //Toast.makeText(context,cant2,Toast.LENGTH_LONG).show();
                            bd4.execSQL("UPDATE pedidosProductos SET cantidad='"+cant2+"' where nombre='"+nombrePlato+"'and numMesa='"+Nummesadora+"'");
                        }

                        Cursor cursorPedidosM = bd4.rawQuery("select precioTotal from pedidos where numMesa='"+Nummesadora+"'",null);
                        Cursor cursorProductosM = bd4.rawQuery("select precio from productos where nombre='"+nombrePlato+"'",null);
                        String precioPedidosM="";
                        String precioProductosM="";

                        if (cursorProductosM.moveToNext()) {
                            precioProductosM=cursorProductosM.getString(0);
                            if (cursorPedidosM.moveToNext()) {

                                precioPedidosM=cursorPedidosM.getString(0);
                                double numEnteroPedidos = Double.parseDouble(precioPedidosM);
                                double numEnteroProductos= Double.parseDouble(precioProductosM);
                                numEnteroPedidos=numEnteroPedidos-numEnteroProductos;
                                if (numEnteroPedidos<0){
                                    precioPedidos="0";
                                }else{
                                    precioPedidos=String.valueOf(numEnteroPedidos);
                                }

                                //Toast.makeText(context,precioPedidos,Toast.LENGTH_LONG).show();
                                bd4.execSQL("UPDATE pedidos SET precioTotal='"+precioPedidos+"' where numMesa='"+Nummesadora+"'");
                            }else{
                                Toast.makeText(context,"Introduzca la mesa",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(context,"fallo productos",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(context,"no hay ningun plato registrado",Toast.LENGTH_LONG).show();
                    }



                    bd4.close();

                    break;
            }
        }
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_platos,null,false);

        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {
        holder.etiNombre.setText(listaUsuario.get(position).getNombre());
        holder.etiStock.setText(listaUsuario.get(position).getStock());
        holder.Etiprecio.setText(listaUsuario.get(position).getPrecio());
        //SET EVENTS
        holder.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

}


