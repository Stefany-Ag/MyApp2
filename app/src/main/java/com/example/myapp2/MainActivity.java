package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String ANIMES = "Anime";
    String error, errorLista, categoria;
    Spinner spinCategoria;
    MediaPlayer mp;
    Anime arrayAnime[] = new Anime[55];
    ImageButton btnAgregar;
    Button btnCheck;
    EditText etNombre, etFecha;
    Anime temporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = getResources().getString(R.string.error);
        errorLista = getResources().getString(R.string.errorLista);
        mp = MediaPlayer.create(this, R.raw.away);
        mp.start();
        etNombre = findViewById(R.id.etNombre);
        etFecha = findViewById(R.id.etFecha);
        spinCategoria = findViewById(R.id.spinCategoria);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(this);
        ArrayAdapter spinAdapter = ArrayAdapter.createFromResource(this,R.array.spinCategoria,android.R.layout.simple_spinner_item);
        spinCategoria.setAdapter(spinAdapter);
        spinCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Seleccionar por categoría...")){
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }else{
                    categoria = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
            }
        });
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
        escondeTeclado(this);
        String nombre = String.valueOf(etNombre.getText());
        String fecha = String.valueOf(etFecha.getText());
        switch(v.getId()){
            case R.id.btnAgregar:
                if(categoria.isEmpty()|| etNombre.getText().length() == 0 || etFecha.getText().length() == 0) {
                    if (etNombre.getText().length() == 0) {
                        etNombre.setError(error);
                    }
                    if (etFecha.getText().length() == 0) {
                        etFecha.setError(error);}
                    else{Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();}
                }
                else
                {
                    int i = 0;
                    temporal = new Anime("" + i , nombre, categoria, fecha);
                    arrayAnime[i] = temporal;
                    etNombre.setText("");
                    etFecha.setText("");
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.exito), Toast.LENGTH_SHORT).show();
                    i++;
                }
                break;
            case R.id.btnCheck:
                if(etNombre.getText().length() == 0||etFecha.getText().length() == 0) {
                    if (etNombre.getText().length() == 0) {
                        etNombre.setError(error);
                    }
                    if (etFecha.getText().length() == 0) {
                        etFecha.setError(error);}
                    Toast.makeText(MainActivity.this, errorLista, Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ANIMES,arrayAnime);
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
        }
    }
    public static void escondeTeclado(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
