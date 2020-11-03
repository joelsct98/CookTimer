package com.example.proyecto_final_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;




import android.view.LayoutInflater;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyecto_final_1.Adaptadores.AdaptadorProductos;
import com.example.proyecto_final_1.MENU.TodosMenus2;


public class PedidosFragment extends Fragment {

    View vista;
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,enviar;
    EditText mesa;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_pedidos, container, false);
        btn1=(ImageButton) vista.findViewById(R.id.bebidas);
        btn2=(ImageButton) vista.findViewById(R.id.primerPlato);
        btn3=(ImageButton) vista.findViewById(R.id.segundoPlato);
        btn4=(ImageButton) vista.findViewById(R.id.pCasa);
        btn5=(ImageButton) vista.findViewById(R.id.raciones);
        btn6=(ImageButton) vista.findViewById(R.id.extras);
        btn7=(ImageButton) vista.findViewById(R.id.postres);
        btn8=(ImageButton) vista.findViewById(R.id.cocteles);
        btn9=(ImageButton) vista.findViewById(R.id.ofertas);
        enviar=(ImageButton) vista.findViewById(R.id.enviar);
        mesa=(EditText) vista.findViewById(R.id.mesageneral);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","bebidas");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);


            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","primerPlato");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","segundoPlato");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }


        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","platosCasa");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }


        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","ensalada");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }


        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","entrantes");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }


        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","postres");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }


        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","cocteles");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);

            }


        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TodosMenus2.class);
                i.putExtra("tipo","ofertas");

                String mesa1= mesa.getText().toString();
                i.putExtra("mesaId",mesa1);

                getActivity().startActivity(i);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mesa1= mesa.getText().toString();
                SharedPreferences datos= getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor miEditor=datos.edit();
                miEditor.putString("valor", mesa1);
                miEditor.apply();
                Toast.makeText(getActivity(),"Mesa registrada",Toast.LENGTH_LONG).show();

            }


        });



        return vista;

    }



}