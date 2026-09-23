package co.edu.uniquindio;

import java.time.LocalDate;

public class Empresa {
    private String id;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    private Cliente[]listClientes;
    private  Desarrollador[]listDesarrollador;
    private Proyecto[]listProyecto;
    private ServiciosAdicionales[]listServicios;

    public Empresa(String id, String nombreComercial, String direccion, String telefono, String paginaWeb, Cliente[] listClientes,
                   Desarrollador[] listDesarrollador, Proyecto[] listProyecto, ServiciosAdicionales[] listServicios) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

        this.listClientes = new Cliente[10];
        this.listDesarrollador = new Desarrollador[10];
        this.listProyecto = new Proyecto[10];
        listServicios = new ServiciosAdicionales[10];
    }
    public boolean registarCliente(Cliente nuevoCliente){
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] == null) {
                listClientes[i] = nuevoCliente;
                return true;
            }
        }
        return false;
    }
    public boolean registrarDesarrollador (Desarrollador nuevoDesarrollador) {
        for (int i = 0; i < listDesarrollador.length; i++) {
            if (listDesarrollador[i] == null) {
                listDesarrollador[i] = nuevoDesarrollador;
                return true;
            }
        }
        return false;
    }
    public boolean registarProyecto (Proyecto nuevoProyecto) {
        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] == null) {
                listProyecto[i] = nuevoProyecto;
                return true;
            }
        }
        return false;
    }
    public boolean registrarServicio(ServiciosAdicionales nuevoServicioAdicional) {
        for (int i = 0; i < listServicios.length; i++) {
            if (listServicios[i] == null) {
                listServicios[i] = nuevoServicioAdicional;
                return true;
            }
        }
        return false;
    }

    public Desarrollador buscarDesarrollador(String codigo) {
        for (int i = 0; i < listDesarrollador.length; i++) {
            if (listDesarrollador[i] != null && listDesarrollador[i].getCodigo().equalsIgnoreCase(codigo)) {
                return listDesarrollador[i];
            }
        }
        return null;
    }
    public Proyecto buscarProyecto(String id){
        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null && listProyecto[i].getId().equalsIgnoreCase(id)) {
                return listProyecto[i];
            }
        }
        return null;
    }
    public ServiciosAdicionales buscarServicio(String codigo) {
        for (int i = 0; i < listServicios.length; i++) {
            if (listServicios[i] != null && listServicios[i].getCodigo().equalsIgnoreCase(codigo)) {
                return listServicios[i];
            }
        }
        return null;
    }
    public boolean asignarDesarrolladorAProyecto(String idProyecto, String codigoDev) {
        Proyecto p = buscarProyecto(idProyecto);
        Desarrollador d = buscarDesarrollador(codigoDev);
        if (p != null && d != null) {
            return p.agregarDesarrollador(d);
        }
        return false;
    }
    public Cliente consultarTelefonoCliente(String buscarTelefono) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].getTelefono().equals(buscarTelefono)) {
                return listClientes[i];
            }
        }
        return null;
    }

    public boolean esPerfecto(String telefono) {
        int numero = Integer.parseInt(telefono);
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }

    public double calcularIngresoFecha(LocalDate fechaConsulta) {
        double ingresoTotal = 0;
        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null && listProyecto[i].getFechaSolicitud().equals(fechaConsulta)) {
                ingresoTotal += listProyecto[i].calcularTotal();
            }
        }
        return ingresoTotal;
    }

    public String mostrarProyecto() {
        String msj = "✿ Lista de proyectos ✿\n";
        boolean hayProyectos = false;
        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null) {
                hayProyectos = true;
                msj += "\n Id: " + listProyecto[i].getId() +
                        "\n Estado: " + listProyecto[i].getEstado() +
                        "\n Fecha Solicitud: " + listProyecto[i].getFechaSolicitud() +
                        "\n Método de Pago: " + listProyecto[i].getMetodoPago() +
                        "\n Total Calculado: $" + listProyecto[i].calcularTotal() +
                        "\n -⋆｡ﾟ☁ ｡⋆｡ ﾟ☾ ﾟ｡⋆⋆｡ﾟ☁ ｡⋆｡ ﾟ☾ ﾟ｡⋆ ";
            }
        }
        if (hayProyectos) {
            return msj;
        } else {
            return "No hay proyectos registrados.";
        }
    }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getNombreComercial() { return nombreComercial; }
    public void setNombreComercial(String nombreComercial) { this.nombreComercial = nombreComercial; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getPaginaWeb() { return paginaWeb; }
    public void setPaginaWeb(String paginaWeb) { this.paginaWeb = paginaWeb; }

}
