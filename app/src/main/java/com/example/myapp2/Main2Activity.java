package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements Serializable{

    ArrayList<Anime1> animes = new ArrayList<Anime1>();
    int[] imagenes = new int[55];
    Anime1 prueba[] = new Anime1[55];
    ListView lvLista;
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.sacar,R.anim.mantener);
        setContentView(R.layout.activity_main2);

        lvLista = findViewById(R.id.lvLista);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        contador =bundle.getInt(MainActivity.COUNT);
        imagenes = bundle.getIntArray(MainActivity.IMG);
        prueba = (Anime1[]) bundle.getSerializable(MainActivity.ANIMES);
        for(int i = 0; i < contador; i++) {
            animes.add(prueba[i]);
        }
        Adapter adaptador = new Adapter(Main2Activity.this, animes,imagenes);
        lvLista.setAdapter(adaptador);
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id = position + 1;//Programar es mi pasión.
                Toast.makeText(Main2Activity.this,getResources().getString(R.string.ID) +id,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.mantener, R.anim.sacar);
    }
}
