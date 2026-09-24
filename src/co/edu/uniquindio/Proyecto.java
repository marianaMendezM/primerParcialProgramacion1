package co.edu.uniquindio;

import java.time.LocalDate;

public class Proyecto {
    private String id;
    private Cliente cliente;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private String estado;
    private String metodoPago;
    private double valorTotal;
    private int diasDesarrollo;
    private double descuentoClienteFrecuente;

    private Desarrollador[] listDesarrollador;
    private ServiciosAdicionales[] listServiciosAdicionales;

    public Proyecto(String id,Cliente cliente, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega,
                    String estado, String metodoPago, int diasDesarrollo, double descuentoClienteFrecuente) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = 0.0;
        this.diasDesarrollo = diasDesarrollo;
        this.descuentoClienteFrecuente = descuentoClienteFrecuente;
        this.listDesarrollador = new Desarrollador[10];
        this.listServiciosAdicionales = new ServiciosAdicionales[10];
        this.cliente=cliente;
    }

    public boolean agregarDesarrollador(Desarrollador nuevo) {
        if (nuevo == null || !nuevo.estaDisponible()) {
            return false;
        }
        for (int i = 0; i < listDesarrollador.length; i++) {
            if (listDesarrollador[i] == null) {
                listDesarrollador[i] = nuevo;
                if (this.estado != null && (this.estado.equalsIgnoreCase("Confirmado") || this.estado.equalsIgnoreCase("En curso"))) {
                    nuevo.setEstado("Asignado");
                }
                return true;
            }
        }
        return false;
    }

    public boolean agregarServicio(ServiciosAdicionales servicio) {
        if (servicio == null) {
            return false;
        }
        for (int i = 0; i < listServiciosAdicionales.length; i++) {
            if (listServiciosAdicionales[i] == null) {
                listServiciosAdicionales[i] = servicio;
                return true;
            }
        }
        return false;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        if (nuevoEstado.equalsIgnoreCase("Confirmado") || nuevoEstado.equalsIgnoreCase("En curso")) {
            for (int i = 0; i < listDesarrollador.length; i++) {
                if (listDesarrollador[i] != null) {
                    listDesarrollador[i].setEstado("Asignado");
                }
            }
        } else if (nuevoEstado.equalsIgnoreCase("Finalizado") || nuevoEstado.equalsIgnoreCase("Cancelado")) {
            for (int i = 0; i < listDesarrollador.length; i++) {
                if (listDesarrollador[i] != null) {
                    listDesarrollador[i].setEstado("Disponible");
                }
            }
        }
    }

    public double calcularTotal() {
        double tarifaDiariaTotal = 0.0;
        for (int i = 0; i < listDesarrollador.length; i++) {
            if (listDesarrollador[i] != null) {
                tarifaDiariaTotal += listDesarrollador[i].getTarifaDiaria();
            }
        }
        double costoDesarrollo = tarifaDiariaTotal * diasDesarrollo;
        double costoServicios = 0.0;
        for (int i = 0; i < listServiciosAdicionales.length; i++) {
            if (listServiciosAdicionales[i] != null) {
                costoServicios += listServiciosAdicionales[i].getPrecio();
            }
        }
        double subtotal = costoDesarrollo + costoServicios;
        double valorDescuento = subtotal * (descuentoClienteFrecuente / 100.0);
        this.valorTotal = subtotal - valorDescuento;
        return this.valorTotal;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDate fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public int getDiasDesarrollo() { return diasDesarrollo; }
    public void setDiasDesarrollo(int diasDesarrollo) { this.diasDesarrollo = diasDesarrollo; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public double getDescuentoClienteFrecuente() { return descuentoClienteFrecuente; }
    public void setDescuentoClienteFrecuente(double descuentoClienteFrecuente) { this.descuentoClienteFrecuente = descuentoClienteFrecuente; }

    public Desarrollador[] getListDesarrollador() { return listDesarrollador; }
    public ServiciosAdicionales[] getListServiciosAdicionales() { return listServiciosAdicionales; }

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
}