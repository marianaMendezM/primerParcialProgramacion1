package co.edu.uniquindio;
import java.time.LocalDate;

public class Proyecto {
    private String id;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private String estado;
    private String metodoPago;
    private double valorTotal;
    private int diasDesarrollo;
    private double descuentoClienteFrecuente;

    private Desarrollador[]listDesaroolador;
    private ServiciosAdicionales[]listServiciosAdicionales;

    public Proyecto(String id, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega, String estado, String metodoPago, double valorTotal, int diasDesarrollo,
                    double descuentoClienteFrecuente, Desarrollador[] listDesaroolador, ServiciosAdicionales[] listServiciosAdicionales) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.diasDesarrollo = diasDesarrollo;
        this.descuentoClienteFrecuente = descuentoClienteFrecuente;
        this.listDesaroolador = listDesaroolador;
        this.listServiciosAdicionales = listServiciosAdicionales;
    }

}

