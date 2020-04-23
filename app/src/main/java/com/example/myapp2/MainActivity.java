package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int ancho, alto;
    ListView lvLista;
    TextView tvNombre, tvGen, tvanio;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        ancho = size.x;
        alto = size.y;

        mp = MediaPlayer.create(this, R.raw.away);
        mp.start();
        lvLista = findViewById(R.id.lvLista);
        String[][] nombres = ListaAnime.getNombre();
    }

    protected void onPause(){
        super.onPause();
        mp.pause();
    }

    protected void onRestart(){
        super.onRestart();
        mp.start();
    }

    protected void onStop(){
        super.onStop();
        mp.stop();
    }

}
