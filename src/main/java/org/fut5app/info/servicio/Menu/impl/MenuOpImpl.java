package org.fut5app.info.servicio.Menu.impl;

import org.fut5app.info.servicio.Equipo.EquipoServicio;
import org.fut5app.info.servicio.Equipo.impl.EquipoServicioImpl;
import org.fut5app.info.servicio.salida.outputFileServicio;
import org.fut5app.info.servicio.salida.impl.outputFileServicioImpl;
import org.fut5app.info.servicio.Menu.MenuOp;
import java.util.Scanner;

public class MenuOpImpl implements MenuOp {

    public static final EquipoServicio EquipoServicio = new EquipoServicioImpl();
    private static final outputFileServicio outputFileServicio = new outputFileServicioImpl();

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Fut5App - Menú");
            System.out.println("1. Crear un equipo");
            System.out.println("2. Buscar jugador por nombre");
            System.out.println("3. Buscar equipo por nombre");
            System.out.println("4. Mostrar jugadores de un equipo");
            System.out.println("5. Eliminar un equipo");
            System.out.println("6. Importar lista de jugadores desde archivo");
            System.out.println("7. Exportar lista de jugadores a archivo");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    EquipoServicio.crearEquipo(scanner);
                    break;
                case 2:
                    EquipoServicio.buscarJugadorPorNombre(scanner);
                    break;
                case 3:
                    EquipoServicio.buscarEquipoPorNombre(scanner);
                    break;
                case 4:
                    EquipoServicio.mostrarJugadoresEquipo(scanner);
                    break;
                case 5:
                    EquipoServicio.eliminarEquipo(scanner);
                    break;
                case 6:
                    EquipoServicio.importarJugadoresDesdeArchivo(scanner);
                    break;
                case 7:
                    EquipoServicio.exportarJugadoresAArchivo(scanner);
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Incorrecto. Por favor, intente nuevamente.");
                    break;
            }
        }
        System.out.print("¡Adios!");
        scanner.close();
    }
}