package com.example.whatsapp;

import java.util.Date;

public class Contacto {

    private int imageResource;
    private String nombre;
    private String estado;
    private String hora;

    public Contacto(int imageResource, String nombre, String estado, String hora) {
        this.imageResource = imageResource;
        this.nombre = nombre;
        this.estado = estado;
        this.hora = hora;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getHora() {
        return hora;
    }
}
