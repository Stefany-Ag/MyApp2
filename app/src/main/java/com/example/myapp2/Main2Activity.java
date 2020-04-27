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

        int[] imagen = {R.drawable.AngelBeats,R.drawable.Another,R.drawable.Clannad,R.drawable.DBZ,R.drawable.ElfenLied,R.drawable.FairyTail,R.drawable.FullMetalA,R.drawable.Inuyasha,R.drawable.Kaichou,R.drawable.NanatsuNoTaizai,R.drawable.Nisekoi};
    }
}
