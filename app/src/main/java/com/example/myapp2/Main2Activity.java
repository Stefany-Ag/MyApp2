package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Anime> animes = new ArrayList<Anime>();
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvLista = findViewById(R.id.lvLista);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        try {
            animes = (ArrayList<Anime>) bundle.getSerializable(MainActivity.ANIMES);
        }catch (NullPointerException e){
            Toast.makeText(this,"Error al mandar los datos", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this,animes.get(0).getNombre(), Toast.LENGTH_SHORT).show();
        Adapter adaptador = new Adapter(this, animes);
        lvLista.setAdapter(adaptador);
    }
}
