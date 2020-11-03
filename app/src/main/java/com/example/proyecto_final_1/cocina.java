package com.example.proyecto_final_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.proyecto_final_1.Adaptadores.CocinaVO;
import com.example.proyecto_final_1.AdminSQLiteOpenHelper;
import com.example.proyecto_final_1.Adaptadores.AdaptadorCocina;

import java.util.ArrayList;


public class cocina extends AppCompatActivity {
    ArrayList<CocinaVO> ListCocina;
    RecyclerView mRecyclerView;
    AdminSQLiteOpenHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);

        bd=new AdminSQLiteOpenHelper(this);


        ListCocina=new ArrayList<>();
        mRecyclerView = (RecyclerView)findViewById(R.id.cocina);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));


    consultarPedisoaTomados();



        final AdaptadorCocina adapter =new AdaptadorCocina(ListCocina);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration divider= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(divider);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                ListCocina.remove(position);
                adapter.notifyItemRemoved(viewHolder.getLayoutPosition());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private void consultarPedisoaTomados() {

        SQLiteDatabase db=bd.getReadableDatabase();
        CocinaVO cocina=null;

        Cursor cursor = db.rawQuery(
                "select nombre from pedidosProductos", null);
        while(cursor.moveToNext()) {
            cocina = new CocinaVO();
            cocina.setPedidosCocina(cursor.getString(0));

            ListCocina.add(cocina);

        }


    }


    }




