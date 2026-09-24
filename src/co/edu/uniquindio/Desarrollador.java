package co.edu.uniquindio;

public class Desarrollador {
    private String codigo;
    private String equipoTrabajo;
    private String nivel;
    private int numProyectosSimultaneos;
    private double tarifaDiaria;
    private String estado;

    public Desarrollador(String codigo, String equipoTrabajo, String nivel, int numProyectosSimultaneos, double tarifaDiaria, String estado) {
        this.codigo = codigo;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.numProyectosSimultaneos = numProyectosSimultaneos;
        this.tarifaDiaria = tarifaDiaria;
        this.estado = estado;
    }
    public boolean estaDisponible() {
        return this.estado != null && this.estado.equalsIgnoreCase("Disponible");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNumProyectosSimultaneos() {
        return numProyectosSimultaneos;
    }

    public void setNumProyectosSimultaneos(int numPoryectosSimultaneos) {
        this.numProyectosSimultaneos = numProyectosSimultaneos;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
