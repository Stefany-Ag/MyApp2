package com.example.myapp2;

import java.io.Serializable;

public class Anime implements Serializable {
    String id, nombre, categoria, duracion;

    public Anime(String id, String nombre, String categoria, String duracion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.duracion = duracion;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
