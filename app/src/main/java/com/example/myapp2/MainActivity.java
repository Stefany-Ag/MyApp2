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
/*
    Facultad de Ingeniería
    Computo móvil. Semestre 2020-1.
    Programado por: Cynthia Estefanía Arreola González.
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String ANIMES = "Anime";
    public static final String IMG = "IMG";
    public static final String COUNT = "Contador";
    String error, errorLista, categoria;
    Spinner spinCategoria;
    MediaPlayer mp;
    Anime1 arrayAnime[] = new Anime1[55];
    int animon[] = new int[55];
    ImageButton btnAgregar;
    Button btnCheck;
    EditText etNombre, etFecha;
    Anime1 temporal;
    int i = 0, j = 0, contador, imagen;

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
                if(parent.getItemAtPosition(position).equals(parent.getItemAtPosition(0).toString())){
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }else{
                    categoria = parent.getItemAtPosition(position).toString();
                    switch(position) {
                        case 1:
                            imagen = R.drawable.accion;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 2:
                            imagen = R.drawable.comedia;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 3:
                            imagen = R.drawable.drama;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 4:
                            imagen = R.drawable.escolar;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 5:
                            imagen = R.drawable.fantasia;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 6:
                            imagen = R.drawable.gore;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 7:
                            imagen = R.drawable.romance;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 8:
                            imagen = R.drawable.shonen;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 9:
                            imagen = R.drawable.terror;
                            animon[j] = imagen;
                            j++;
                            break;
                        case 10:
                            imagen = R.drawable.videojuegos;
                            animon[j] = imagen;
                            j++;
                            break;
                        default:
                            Toast.makeText(MainActivity.this,getResources().getString(R.string.extra),Toast.LENGTH_SHORT).show();
                            break;
                    }
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
                if(spinCategoria.getSelectedItemPosition()== 0|| categoria.isEmpty()|| etNombre.getText().length() == 0 || etFecha.getText().length() == 0) {
                    if (etNombre.getText().length() == 0) {
                        etNombre.setError(error);
                    }
                    if (etFecha.getText().length() == 0) {
                        etFecha.setError(error);}
                    if(spinCategoria.getSelectedItemPosition()==0)
                    {
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    temporal = new Anime1("" + i , nombre, categoria, fecha);
                    arrayAnime[i] = temporal;
                    etNombre.setText("");
                    etFecha.setText("");
                    spinCategoria.setSelection(0);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.exito), Toast.LENGTH_SHORT).show();
                    i++;
                    contador = i;
                }
                break;
            case R.id.btnCheck:
                if(i<1) {
                    if (etNombre.getText().length() == 0) {
                        etNombre.setError(error);
                    }
                    if (etFecha.getText().length() == 0) {
                        etFecha.setError(error);}
                    Toast.makeText(MainActivity.this, errorLista, Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ANIMES,arrayAnime);
                    bundle.putInt(COUNT, contador);
                    bundle.putIntArray(IMG, animon);
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