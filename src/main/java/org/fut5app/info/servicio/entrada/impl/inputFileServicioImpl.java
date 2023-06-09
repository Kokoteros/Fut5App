package org.fut5app.info.servicio.entrada.impl;

import org.fut5app.info.domain.Jugador;
import org.fut5app.info.servicio.entrada.inputFileServicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class inputFileServicioImpl implements inputFileServicio {
    @Override
    public Jugador importarJugadores(String nombreArchivo) {
        List<Jugador> jugadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (Jugador) jugadores;
    }
}
