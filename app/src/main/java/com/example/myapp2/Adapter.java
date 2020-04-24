package com.example.myapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] datos;
    int[] imagen;

    public Adapter(Context contexto, String[][] datos, int[] imagenes){
        this.contexto = contexto;
        this.datos = datos;
        this.imagen = imagenes;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return imagen.length;
    }

    @Override
    public Object getItem(int position) {
        return datos[position];
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(datos[position][0]);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.element_list,null);
        TextView nombre = vista.findViewById(R.id.tvNombre);
        TextView categoria = vista.findViewById(R.id.tvCategoria);
        TextView duracion = vista.findViewById(R.id.tvDuracion);
        ImageView image = vista.findViewById(R.id.ivImagen);
        nombre.setText(datos[position][1]);
        categoria.setText(datos[position][2]);
        duracion.setText(datos[position][3]);
        image.setImageResource(imagen[position]);
        image.setTag(position);
        return null;
    }
}
