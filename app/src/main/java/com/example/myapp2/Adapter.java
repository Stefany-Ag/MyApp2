package com.example.myapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private ArrayList<Anime> datos;

    public Adapter(Context contexto, ArrayList datos){
        this.contexto = contexto;
        this.datos = datos;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(datos.get(position).id);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.element_list,null);
        TextView nombre = vista.findViewById(R.id.tvNombre);
        TextView categoria = vista.findViewById(R.id.tvCategoria);
        TextView duracion = vista.findViewById(R.id.tvDuracion);
        nombre.setText(datos.get(position).nombre);
        categoria.setText(datos.get(position).categoria);
        duracion.setText(datos.get(position).fecha);
        return null;
    }
}
