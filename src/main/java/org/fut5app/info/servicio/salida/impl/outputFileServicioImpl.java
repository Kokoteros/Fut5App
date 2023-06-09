package org.fut5app.info.servicio.salida.impl;

import org.fut5app.info.domain.Jugador;
import org.fut5app.info.servicio.salida.outputFileServicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class outputFileServicioImpl implements outputFileServicio {
        public void exportarJugadoresAArchivo(String nombreArchivo, List<Jugador> jugadores) {
            try (FileWriter fileWriter = new FileWriter("listJug.txt")) {
                for (Jugador jugador : jugadores) {
                    String linea = jugador.getNombre() + "," + jugador.getApellido() + "," + jugador.getAltura() + "," +
                            jugador.getPosicion() + "," + jugador.getGoles() + "," + jugador.getPartidos() + "," +
                            jugador.esCapitan() + "," + jugador.getNum_Camiseta() + "," + jugador.getEquipo().getNombre();
                    fileWriter.write(linea);
                    fileWriter.write("\n");
                }
            } catch (IOException e) {
                System.out.println("Error al exportar jugadores al archivo: " + e.getMessage());
            }
        }


        @Override
        public void exportarJugadoresAArchivo(String rutaArchivoSalida) {

        }
}
