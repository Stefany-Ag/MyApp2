package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String Nombre = "Nombre";
    public static final String Categoria = "Categoria";
    public static final String Duracion = "Duracion";
    public static final String ANIMES = "Anime";
    String error;
    Spinner spinNombre, spinCategoria;
    ListView lvLista;
    MediaPlayer mp;
    ArrayList<Anime> animes = new ArrayList<Anime>();
    ImageButton btnAgregar, btnAgregar2;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = getResources().getString(R.string.error);
        mp = MediaPlayer.create(this, R.raw.away);
        mp.start();
        lvLista = findViewById(R.id.lvLista);
        spinNombre = findViewById(R.id.spinNombre);
        spinCategoria = findViewById(R.id.spinCategoria);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
        btnAgregar2 = findViewById(R.id.btnAgregar2);
        btnAgregar2.setOnClickListener(this);
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(this);
        ArrayAdapter spinAdapter = ArrayAdapter.createFromResource(this,R.array.spinNombre,android.R.layout.simple_spinner_item);
        spinNombre.setAdapter(spinAdapter);
        ArrayAdapter spinAdapter2 = ArrayAdapter.createFromResource(this,R.array.spinCategoria,android.R.layout.simple_spinner_item);
        spinCategoria.setAdapter(spinAdapter2);
        String[][] datos = {
                {"100","Angel Beats!","Drama, Escolar","13 capítulos"},
                {"101","Another","Gore, Terror","12 capítulos"},
                {"102","Clannad","Drama, Escolar","23 capítulos"},
                {"103","Dragon Ball Z","Shonen, Acción","291 capítulos"},
                {"104","Elfen Lied","Gore, Drama","13 capítulos"},
                {"105","Fairy Tail","Shonen, Comedia","328 capítulos"},
                {"106","Full Metal Alchemist","Drama, Fantasía","51 capítulos"},
                {"107","Inuyasha","Drama, Fantasía","167 capítulos"},
                {"108","Kaichou wa Maid-Sama","Comedia, Romance","26 capítulos"},
                {"109","Nanatsu no Taizai","Shonen","24 capítulos"},
                {"110","Nisekoi","Comedia, Romance","20 capítulos"}
        };
        int[] imagen = {R.drawable.AngelBeats,R.drawable.Another,R.drawable.Clannad,R.drawable.DBZ,R.drawable.ElfenLied,R.drawable.FairyTail,R.drawable.FullMetalA,R.drawable.Inuyasha,R.drawable.Kaichou,R.drawable.NanatsuNoTaizai,R.drawable.Nisekoi};
        Adapter adaptador = new Adapter(this, datos, imagen);
        lvLista.setAdapter(adaptador);
        /*lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "ID: " + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ANIMES,animes);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });*/
        spinNombre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Seleccionar por nombre...")){
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        if(parent.getItemAtPosition(position).equals("Angel Beats!")){

                        }
                    }catch(Exception e){

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
            }
        });
       /* spinCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Seleccionar por categoría...")){
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }else{

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
            }
        });*/
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAgregar:
                //Anime temporal = new Anime ("",Nombre, Categoria, Duracion);
                //animes.add(temporal);
                break;
            case R.id.btnAgregar2:
                break;
            case R.id.btnCheck:
                if(animes.isEmpty()){
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
