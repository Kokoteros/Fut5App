package org.fut5app.info.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String creacion;
    private Entrenador entrenador;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String creacion, Entrenador entrenador) {
        this.nombre = nombre;
        this.creacion = creacion;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return (List<Jugador>) jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = (List<Jugador>) jugadores;
    }
}