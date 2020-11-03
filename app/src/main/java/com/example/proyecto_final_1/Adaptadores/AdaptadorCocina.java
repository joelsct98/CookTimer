package com.example.proyecto_final_1.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_1.R;

import java.util.ArrayList;

public class AdaptadorCocina extends RecyclerView.Adapter<AdaptadorCocina.ViewHolderCocina> {

    ArrayList<CocinaVO> ListCocina;

    public AdaptadorCocina(ArrayList<CocinaVO> ListCocina) {
        this.ListCocina = ListCocina;
    }

    @NonNull
    @Override
    public AdaptadorCocina.ViewHolderCocina onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cocina,null,false);
        return new ViewHolderCocina(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCocina holder, int position) {

        holder.dato.setText(ListCocina.get(position).getPedidosCocina());

    }

    @Override
    public int getItemCount() {
        return ListCocina.size();
    }

    public class ViewHolderCocina extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolderCocina(@NonNull View itemView) {
            super(itemView);
            dato=(TextView)itemView.findViewById(R.id.pedidoCocina);
        }


    }
}
