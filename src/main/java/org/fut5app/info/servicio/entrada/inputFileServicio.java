package org.fut5app.info.servicio.entrada;

import org.fut5app.info.domain.Jugador;

public interface inputFileServicio {
    public abstract Jugador importarJugadores(String nombreArchivo);
}