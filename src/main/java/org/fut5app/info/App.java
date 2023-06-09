package org.fut5app.info;

import org.fut5app.info.domain.Jugador;
import org.fut5app.info.servicio.entrada.impl.inputFileServicioImpl;
import org.fut5app.info.servicio.Menu.MenuOp;
import org.fut5app.info.servicio.Menu.impl.MenuOpImpl;
import org.fut5app.info.servicio.salida.outputFileServicio;
import org.fut5app.info.servicio.salida.impl.outputFileServicioImpl;

import java.io.IOException;

public class App {

    private static final inputFileServicioImpl inputFileServicio = new inputFileServicioImpl();

    private static final outputFileServicio outputFileServicio = new outputFileServicioImpl();


    public static void main(String[] args) throws IOException {

        MenuOp menuOp = new MenuOpImpl();
        menuOp.menu();

        String rutaArchivo = ".src/main/java/org/fut5app/info/resources/listajugadores.txt";

        Jugador jugadores = inputFileServicio.importarJugadores(rutaArchivo);
        System.out.println("Archivo creado");

        String rutaArchivoSalida =".src/main/java/org/fut5app/info/resources";
        System.out.println("Archivo creado");

        outputFileServicio.exportarJugadoresAArchivo(rutaArchivoSalida);
    }
}