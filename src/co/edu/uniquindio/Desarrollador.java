package co.edu.uniquindio;

public class Desarrollador {
    private String codigo;
    private String equipoTrabajo;
    private String nivel;
    private int numPoryectosSimultaneos;
    private double tarifaDiaria;
    private String estado;

    public Desarrollador(String codigo, String equipoTrabajo, String nivel, int numPoryectosSimultaneos, double tarifaDiaria, String estado) {
        this.codigo = codigo;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.numPoryectosSimultaneos = numPoryectosSimultaneos;
        this.tarifaDiaria = tarifaDiaria;
        this.estado = estado;
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

    public int getNumPoryectosSimultaneos() {
        return numPoryectosSimultaneos;
    }

    public void setNumPoryectosSimultaneos(int numPoryectosSimultaneos) {
        this.numPoryectosSimultaneos = numPoryectosSimultaneos;
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
