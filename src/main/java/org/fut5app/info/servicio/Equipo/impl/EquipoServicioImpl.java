package org.fut5app.info.servicio.Equipo.impl;


import org.fut5app.info.domain.Entrenador;
import org.fut5app.info.domain.Equipo;
import org.fut5app.info.domain.Jugador;
import org.fut5app.info.servicio.Equipo.EquipoServicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipoServicioImpl implements EquipoServicio {


    private static List<Equipo> Equipos = new ArrayList<>();
    private static Scanner scanner;

    public void crearEquipo(Scanner scanner) {
        EquipoServicioImpl.scanner = scanner;
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();
        System.out.print("Ingrese la fecha de creación del equipo: ");
        String creacion = scanner.next();
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombreEntrenador = scanner.next();
        System.out.print("Ingrese el apellido del entrenador: ");
        String apellidoEntrenador = scanner.next();
        System.out.print("Ingrese la edad del entrenador: ");
        int edadEntrenador = scanner.nextInt();

        Entrenador entrenador = new Entrenador(nombreEntrenador, apellidoEntrenador, edadEntrenador);
        Equipo equipo = new Equipo(nombreEquipo, creacion, entrenador);
        Equipos.add(equipo);

        boolean cargarJugadores = true;
        while (cargarJugadores) {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombreJugador = scanner.next();
            System.out.print("Ingrese el apellido del jugador: ");
            String apellidoJugador = scanner.next();
            System.out.print("Ingrese la altura del jugador: ");
            double alturaJugador = scanner.nextDouble();
            System.out.print("Ingrese la posición del jugador (Arquero/Defensor/Mediocampista/Delantero): ");
            String posicionJugador = scanner.next();
            System.out.print("Ingrese la cantidad de goles del jugador: ");
            int golesJugador = scanner.nextInt();
            System.out.print("Ingrese la cantidad de partidos del jugador: ");
            int partidosJugador = scanner.nextInt();
            System.out.print("¿El jugador es capitán? (True/False): ");
            boolean esCapitan = scanner.nextBoolean();
            System.out.print("Ingrese el número de camiseta del jugador: ");
            int numeroCamiseta = scanner.nextInt();

            Jugador jugador = new Jugador(nombreJugador, apellidoJugador, alturaJugador, posicionJugador,
                    golesJugador, partidosJugador, esCapitan, numeroCamiseta, equipo);
            equipo.getJugadores().add(jugador);

            System.out.print("¿Desea cargar más jugadores para este equipo? (True/False): ");
            cargarJugadores = scanner.nextBoolean();
        }
        System.out.print("¿Desea cargar más equipos? (True/False): ");
        boolean cargarEquipos = scanner.nextBoolean();
        if (!cargarEquipos) {
            System.out.println("Equipos cargados correctamente.");
        }
    }


    public void buscarJugadorPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador a buscar: ");
        String nombreJugador = scanner.next();

        for (Equipo equipo : Equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Posición: " + jugador.getPosicion());
                    System.out.println("Es capitán: " + (jugador.esCapitan() ? "Sí" : "No"));
                    System.out.println("Equipo: " + jugador.getEquipo().getNombre());
                    return;
                }
            }
        }

        System.out.println("No existe jugador con ese nombre.");
    }

    @Override
    public void buscarEquipoPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo a buscar: ");
        String nombreEquipo = scanner.next();

        for (Equipo equipo : Equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                System.out.println("Capitán: " + obtenerNombreCapitan(equipo));
                return;
            }
        }

        System.out.println("No existe equipo con ese nombre.");
    }

    private String obtenerNombreCapitan(Equipo equipo) {
        for (Jugador jugador : equipo.getJugadores()) {
            if (!jugador.esCapitan) {
            } else {
                return jugador.getNombre() + " " + jugador.getApellido();
            }
        }

        return "No hay capitán asignado";
    }

    @Override
    public void mostrarJugadoresEquipo(Scanner scanner) {
        EquipoServicioImpl.scanner = scanner;
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();

        for (Equipo equipo : Equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                System.out.println("Jugadores del equipo:");

                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println("- " + jugador.getNombre() + " " + jugador.getApellido());
                }

                return;
            }
        }

        System.out.println("No existe equipo con ese nombre.");
    }

    @Override
    public void eliminarEquipo(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo a eliminar: ");
        String nombreEquipo = scanner.next();

        for (int i = 0; i < Equipos.size(); i++) {
            if (Equipos.get(i).getNombre().equalsIgnoreCase(nombreEquipo)) {
                Equipos.remove(i);
                System.out.println("El equipo se ha eliminado.");
                return;
            }
        }

        System.out.println("No existe equipo con ese nombre.");
    }

    @Override
    public void importarJugadoresDesdeArchivo(Scanner scanner) {
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.next();

        try {
            File archivo = new File(nombreArchivo);
            Scanner lector = new Scanner(archivo);

            List<Jugador> jugadoresImportados = new ArrayList<>();

            if (lector.hasNextLine()) {
                lector.nextLine();
            }

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();

                String[] campos = linea.split(",");

                if (campos.length == 9) {
                    // valores
                    String nombre = campos[0].trim();
                    String apellido = campos[1].trim();
                    double altura = Double.parseDouble(campos[2].trim());
                    String posicion = campos[3].trim();
                    int goles = Integer.parseInt(campos[4].trim());
                    int partidos = Integer.parseInt(campos[5].trim());
                    boolean esCapitan = Boolean.parseBoolean(campos[6].trim());
                    int numeroCamiseta = Integer.parseInt(campos[7].trim());
                    String nombreEquipo = campos[8].trim();


                    Jugador jugador = new Jugador(nombre, apellido, altura, posicion, goles, partidos, esCapitan, numeroCamiseta);
                    jugadoresImportados.add(jugador);
                }
            }

            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al importar jugadores desde el archivo: Archivo no encontrado");
        }
    }

    @Override
    public void exportarJugadoresAArchivo(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.next();


        for (Equipo equipo : Equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {

                List<Jugador> jugadores = equipo.getJugadores();

                try (FileWriter writer = new FileWriter("./src/main/java/com/infotp1/futApp5/resources/"+ nombreArchivo)) {

                    writer.write("Equipo,Nombre,Apellido,Altura,Posicion,Goles,Partidos,EsCapitan,Num_Camiseta\n");

                    for (Jugador jugador : jugadores) {
                        writer.write(jugador.getNombre() + ",");
                        writer.write(jugador.getApellido() + ",");
                        writer.write(jugador.getAltura() + ",");
                        writer.write(jugador.getPosicion() + ",");
                        writer.write(jugador.getGoles() + ",");
                        writer.write(jugador.getPartidos() + ",");
                        writer.write(jugador.esCapitan() + ",");
                        writer.write(jugador.getNum_Camiseta() + "\n");
                    }

                    System.out.println("Archivo creado " + nombreArchivo);
                } catch (IOException e) {
                    System.out.println("Error al exportar jugadores: " + e.getMessage());
                }

                return;
            }
        }

        System.out.println("No se encontró ningún equipo con ese nombre.");
    }

}
