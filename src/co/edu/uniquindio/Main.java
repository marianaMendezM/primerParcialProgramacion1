package co.edu.uniquindio;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    private static Empresa empresa;

    public static void main(String[] args) {
        empresa = new Empresa("18272026-02", "DevPlus", "Calle 10 #23 - 14", "3219393229", "www.devplus.com");
        int opcion = 0;

        do {
            String menu = " ⋆˚｡⋆ Menu devplus ⋆˚｡⋆ \n" +
                    "⋅♡ Selecciona una opcion del siguiente menu: ♡⋅ \n" +
                    "1. Registrar cliente \n" +
                    "2. Registrar desarrollador \n" +
                    "3. Registrar servicio adicional \n" +
                    "4. Registrar proyecto \n" +
                    "5. Asignar desarrollador a un proyecto \n" +
                    "6. Asociar servicio adicional a un proyecto \n" +
                    "7. Cambiar estado de proyecto \n" +
                    "8. Consultar cliente por teléfono \n" +
                    "9. Calcular ingresos por fecha \n" +
                    "10. Mostrar todos los proyectos \n" +
                    "11. Consultar Valor Total de un Proyecto \n" +
                    "0. Salir del menu";

            String mostrarMenu = JOptionPane.showInputDialog(menu);
            if (mostrarMenu == null) {
                return;
            }
            opcion = Integer.parseInt(mostrarMenu);

            switch (opcion) {
                case 1:
                    solicitarCliente();
                    break;
                case 2:
                    solicitarDesarrollador();
                    break;
                case 3:
                    solicitarServicio();
                    break;
                case 4:
                    solicitarProyecto();
                    break;
                case 5:
                    asignarDesarrollador();
                    break;
                case 6:
                    asociarServicio();
                    break;
                case 7:
                    cambiarEstadoProyecto();
                    break;
                case 8:
                    solicitarConsultarCliente();
                    break;
                case 9:
                    solicitarIngresosFecha();
                    break;
                case 10:
                    String listaProyectos = empresa.mostrarProyecto();
                    JOptionPane.showMessageDialog(null, listaProyectos);
                    break;
                case 11:
                    solicitarTotalProyecto();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "༺ Programa finalizado ༻");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor ingresa una opcion valida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void solicitarCliente() {
        boolean cliente = empresa.registarCliente(new Cliente(
                pedirDatos("Ingrese la Cédula / NIT:"),
                pedirDatos("Ingrese el Nombre / Razón social:"),
                pedirDatos("Ingrese el número de teléfono:"),
                pedirDatos("Ingrese el correo del cliente:"),
                pedirDatos("Ingrese el país de procedencia:")
        ));
        mostrarMensaje(cliente ? "Cliente registrado exitosamente." : "Sin espacio para más clientes.");
    }

    private static void solicitarDesarrollador() {
        boolean desarrollador = empresa.registrarDesarrollador(new Desarrollador(
                pedirDatos("Ingrese el Código/Cédula del desarrollador:"),
                pedirDatos("Ingrese el equipo de trabajo:"),
                pedirDatos("Nivel (Junior/Semisenior/Senior):"),
                Integer.parseInt(pedirDatos("Máx. Proyectos simultáneos:")),
                Double.parseDouble(pedirDatos("Tarifa diaria ($):")),
                pedirDatos("Estado (Disponible/Asignado/Ocupado/En capacitación):")
        ));
        mostrarMensaje(desarrollador ? "Desarrollador registrado exitosamente." : "Sin espacio para más desarrolladores.");
    }

    private static void solicitarServicio() {
        boolean servicio = empresa.registrarServicio(new ServiciosAdicionales(
                pedirDatos("Ingrese el Código:"),
                pedirDatos("Ingrese el nombre del servicio:"),
                pedirDatos("Descripción:"),
                Double.parseDouble(pedirDatos("Precio del servicio ($):")),
                pedirDatos("Disponibilidad:")
        ));
        mostrarMensaje(servicio ? "Servicio registrado exitosamente." : "Sin espacio para más servicios.");
    }

    private static void solicitarProyecto() {
        boolean proyecto = empresa.registarProyecto(new Proyecto(
                pedirDatos("Código:"),
                LocalDate.parse(pedirDatos("Fecha Solicitud (ej: 2026-05-10):")),
                LocalDate.parse(pedirDatos("Fecha Inicio (ej: 2026-05-10):")),
                LocalDate.parse(pedirDatos("Fecha Entrega (ej: 2026-05-10):")),
                pedirDatos("Estado (Pendiente/Confirmado/En curso/Finalizado/Cancelado):"),
                pedirDatos("Método Pago (Tarjeta/Transferencia/Efectivo):"),
                Integer.parseInt(pedirDatos("Días de desarrollo estimado:")),
                Double.parseDouble(pedirDatos("Porcentaje de descuento (%):"))
        ));

        mostrarMensaje(proyecto ? "Proyecto registrado exitosamente." : "Sin espacio para más proyectos.");
    }

    private static void asignarDesarrollador() {
        boolean exito = empresa.asignarDesarrolladorAProyecto(
                pedirDatos("Código del proyecto:"),
                pedirDatos("Código del desarrollador:")
        );
        mostrarMensaje(exito ? "Desarrollador asignado exitosamente al proyecto."
                : "No se pudo asignar. Verifique que el proyecto exista y que el desarrollador esté 'Disponible'.");
    }

    private static void asociarServicio() {
        boolean exito = empresa.asociarServicioAProyecto(
                pedirDatos("Código del proyecto:"),
                pedirDatos("Código del servicio adicional:")
        );
        mostrarMensaje(exito ? "Servicio asociado exitosamente al proyecto."
                : "No se pudo asociar el servicio. Verifique los códigos.");
    }

    private static void cambiarEstadoProyecto() {
        boolean exito = empresa.cambiarEstadoProyecto(
                pedirDatos("Código del proyecto:"),
                pedirDatos("Nuevo Estado (Confirmado, En curso, Finalizado, Cancelado):")
        );
        mostrarMensaje(exito ? "Estado actualizado correctamente." : "Proyecto no encontrado.");
    }

    private static void solicitarConsultarCliente() {
        String tel = pedirDatos("Ingrese teléfono del cliente a consultar:");
        Cliente cliente = empresa.consultarTelefonoCliente(tel);

        if (cliente != null) {
            mostrarMensaje("Cliente encontrado:\n" +
                    "Nombre: " + cliente.getNombre() + "\n" +
                    "Cédula/NIT: " + cliente.getCedula() + "\n" +
                    "Teléfono: " + cliente.getTelefono() + "\n" +
                    "¿El teléfono es un Número Perfecto?: " + (empresa.esPerfecto(tel) ? "SÍ" : "NO"));
        } else {
            mostrarMensaje("No existe un cliente con el teléfono " + tel);
        }
    }

    private static void solicitarIngresosFecha() {
        LocalDate fecha = LocalDate.parse(pedirDatos("Ingrese fecha a consultar (ej: 2026-05-10):"));
        mostrarMensaje("El total recaudado por proyectos solicitados el " + fecha + " es: $" + empresa.calcularIngresoFecha(fecha));
    }

    private static void solicitarTotalProyecto() {
        String id = pedirDatos("Ingrese el código del proyecto:");
        double total = empresa.consultarTotalProyecto(id);
        mostrarMensaje(total != -1 ? "El valor total calculated para el proyecto " + id + " es: $" + total
                : "Proyecto no encontrado.");
    }

    private static String pedirDatos(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}