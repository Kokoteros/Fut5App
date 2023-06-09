package org.fut5app.info.servicio.Equipo;

import java.util.Scanner;

public interface EquipoServicio {
    void crearEquipo(Scanner scanner);
    void buscarJugadorPorNombre(Scanner scanner);
    void buscarEquipoPorNombre(Scanner scanner);
    void mostrarJugadoresEquipo(Scanner scanner);
    void eliminarEquipo(Scanner scanner);
    void importarJugadoresDesdeArchivo(Scanner scanner);
    void exportarJugadoresAArchivo(Scanner scanner);
}