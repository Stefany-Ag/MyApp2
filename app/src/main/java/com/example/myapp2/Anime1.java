package com.example.myapp2;

import java.io.Serializable;

public class Anime1 implements Serializable{
    String id, nombre, categoria, fecha;

    public Anime1(String id, String nombre, String categoria, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}