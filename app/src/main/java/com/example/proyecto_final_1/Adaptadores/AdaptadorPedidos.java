package com.example.proyecto_final_1.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.PlatosActivity;
import com.example.proyecto_final_1.R;
import com.example.proyecto_final_1.entidades.Pedidos;

import java.util.ArrayList;

public class AdaptadorPedidos extends RecyclerView.Adapter<AdaptadorPedidos.ViewHolderPedidos>{//cambiar Adaprter pedidos por como se llama tu class, vamos mismonombre
    ArrayList<Pedidos> listaUsuario;  //poner el objeto q vas a usar como array de objetos
    static class ViewHolderPedidos extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView EtiMesa,etiPrecio;
        Button btnConsultar,btnBorrar;
        Context context;
        AdminSQLiteOpenHelper conn;

        public ViewHolderPedidos(View itemView) {          //aqui solo pones las variables q estan dentro del layout q has enlazado y donde quieras q vaya y ya
            super(itemView);
            EtiMesa= (TextView) itemView.findViewById(R.id.IdMesa);
            etiPrecio=(TextView) itemView.findViewById(R.id.IdPrecio);
            btnConsultar=(Button) itemView.findViewById(R.id.btnConsultar);
            btnBorrar=(Button) itemView.findViewById(R.id.btnBaja);
            context=itemView.getContext();

        }
        void setOnClickListener(AdaptadorPedidos adaptadorPedidos){
            btnConsultar.setOnClickListener(this);
            btnBorrar.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnConsultar:
                    Intent i = new Intent(context, PlatosActivity.class);
                    i.putExtra("mesa",EtiMesa.getText());

                    context.startActivity(i);
                    break;

                case R.id.btnBaja:
                    conn = new AdminSQLiteOpenHelper(context);
                    SQLiteDatabase bd=conn.getWritableDatabase();

                    String mesa=EtiMesa.getText().toString();
                    Toast.makeText(context,"borrado",Toast.LENGTH_LONG).show();
                    //Cursor cursor = bd.rawQuery("select * from pedidosProductos where nombre='"+nombre+"'",null);
                    bd.execSQL("DELETE FROM pedidosProductos WHERE numMesa='"+mesa+"'");

                    bd.execSQL("UPDATE pedidos SET precioTotal='0' where numMesa='"+mesa+"'");

                    break;

            }

        }
    }

    public AdaptadorPedidos(ArrayList<Pedidos> listaUsuario) {//constructor, cambiar objeto
        this.listaUsuario = listaUsuario;
    }

    @Override
    public ViewHolderPedidos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pedidos,null,false);//cambiar layaout
        /**/
        return new ViewHolderPedidos(view);
    }



    @Override
    public void onBindViewHolder(ViewHolderPedidos holder, int position) {
        holder.EtiMesa.setText(listaUsuario.get(position).getNumMesa());
        holder.etiPrecio.setText(listaUsuario.get(position).getPrecioTotal());

        // set events
        holder.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();//cuenta el tamaño de del array de obejtos q tiene dentro, es importante
    }
}