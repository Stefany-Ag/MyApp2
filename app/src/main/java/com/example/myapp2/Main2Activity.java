package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Anime> animes = new ArrayList<Anime>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        animes = (ArrayList<Anime>) bundle.getSerializable(MainActivity.ANIMES);
        Toast.makeText(this,animes.get(3).getNombre(), Toast.LENGTH_SHORT).show();
        //Adapter adaptador = new Adapter(this, datos);
        //lvLista.setAdapter(adaptador);
    }
}
