package co.edu.uniquindio;

public class ServiciosAdicionales {
    private String codigo;
    private String nombre;
    private String descripccion;
    private double precio;
    private String disponibilidad;

    public ServiciosAdicionales(String codigo, String nombre, String descripccion, double precio, String disponibilidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
