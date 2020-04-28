package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements Serializable {

    ArrayList<Anime> animes = new ArrayList<Anime>();
    Anime prueba[] = new Anime[55];
    ListView lvLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvLista = findViewById(R.id.lvLista);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        prueba = (Anime[]) bundle.getSerializable(MainActivity.ANIMES);
        for(int i = 0; i < prueba.length; i++)
        {
            animes.add(prueba[i]);
            Adapter adaptador = new Adapter(Main2Activity.this, animes);
            lvLista.setAdapter(adaptador);
        }

    }
}
