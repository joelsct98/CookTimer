package com.example.proyecto_final_1.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_1.R;
import com.example.proyecto_final_1.entidades.PedidosDentro;
import com.example.proyecto_final_1.entidades.Productos;

import java.util.ArrayList;

public class AdaptadorPedidosDentro extends RecyclerView.Adapter<AdaptadorPedidosDentro.ViewHolderPedidosDentro> {
    ArrayList<PedidosDentro> listaUsuario;

    public AdaptadorPedidosDentro(ArrayList<PedidosDentro> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @Override
    public ViewHolderPedidosDentro onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pedido_listado,null,false);

        return new ViewHolderPedidosDentro(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPedidosDentro holder, int position) {
        holder.etiNombre.setText(listaUsuario.get(position).getNombreP());
        holder.cant.setText(listaUsuario.get(position).getCantidad());

    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class ViewHolderPedidosDentro extends RecyclerView.ViewHolder {
        TextView etiNombre,cant;

        public ViewHolderPedidosDentro(View itemView) {
            super(itemView);
            etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
            cant = (TextView) itemView.findViewById(R.id.idcant);
        }
    }
}
