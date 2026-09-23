package co.edu.uniquindio;

public class Empresa {
    private String id;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    private Cliente[]listClientes;
    private  Desarrollador[]listDesarrollador;
    private Proyecto[]listProyecto;
    private ServiciosAdicionales[]ListServicios;

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
        ListServicios = new ServiciosAdicionales[10];
    }
}
