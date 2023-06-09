package org.fut5app.info.domain;

public class Jugador {

    private String nombre;
    private String apellido;
    private double altura;
    private String posicion;
    private int goles;
    private int partidos;
    public boolean esCapitan;
    private int num_camiseta;
    private Equipo equipo;

    public Jugador(String nombre, String apellido, double altura, String posicion, int goles, int partidos,
                   boolean esCapitan, int num_camiseta, Equipo equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.posicion = posicion;
        this.goles = goles;
        this.partidos = partidos;
        this.esCapitan = esCapitan;
        this.num_camiseta = num_camiseta;
        this.equipo = equipo;
    }

    public Jugador(String nombre, String apellido, double altura, String posicion, int goles, int partidos, boolean esCapitan, int num_camiseta) {
    }


    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public boolean esCapitan() {
        return esCapitan;
    }

    public void setEsCapitan() {
        this.esCapitan = esCapitan;
    }

    public int getNum_Camiseta() {
        return num_camiseta;
    }

    public void setNum_Camiseta(int num_camiseta) {
        this.num_camiseta = num_camiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerPosicion() {
        return posicion;
    }

    public String obtenerEquipo() {
        return equipo.getNombre();
    }
}
