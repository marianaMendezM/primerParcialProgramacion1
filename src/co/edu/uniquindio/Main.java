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
        boolean registro = empresa.registrarCliente(new Cliente(
                pedirDatos("Ingrese la Cédula / NIT:"),
                pedirDatos("Ingrese el Nombre / Razón social:"),
                pedirDatos("Ingrese el número de teléfono:"),
                pedirDatos("Ingrese el correo del cliente:"),
                pedirDatos("Ingrese el país de procedencia:")
        ));

        if (registro) {
            mostrarMensaje("Cliente registrado exitosamente.");
        } else {
            mostrarMensaje("El cliente ya existe o no hay espacio disponible.");
        }
    }

    private static void solicitarDesarrollador() {
        boolean registro = empresa.registrarDesarrollador(new Desarrollador(
                pedirDatos("Ingrese el Código/Cédula del desarrollador:"),
                pedirDatos("Ingrese el equipo de trabajo:"),
                pedirDatos("Nivel (Junior/Semisenior/Senior):"),
                Integer.parseInt(pedirDatos("Máx. Proyectos simultáneos:")),
                Double.parseDouble(pedirDatos("Tarifa diaria ($):")),
                pedirDatos("Estado (Disponible/Asignado/Ocupado/En capacitación):")
        ));

        if (registro) {
            mostrarMensaje("Desarrollador registrado exitosamente.");     
        }else{
            mostrarMensaje("Sin espacio para más desarrolladores ");
        }
    }

    private static void solicitarServicio() {
        String codigo = pedirDatos("Ingrese el Código:");
        String nombre = pedirDatos("Ingrese el nombre del servicio:" + "\n" +
                "Soporte técnico" + "\n" + "Capacitación de usuarios" + "\n" +
                "Despliegue en la nube" + "\n" + "Migración de datos");
        String descripcion = pedirDatos("Descripción:");
        double precio = Double.parseDouble(pedirDatos("Precio del servicio ($):"));
        String disponibilidad = pedirDatos("¿Está disponible? (SI/NO):");
        if (!disponibilidad.trim().equalsIgnoreCase("SI")) {
            mostrarMensaje("El servicio no está disponible, por lo que no se registrará en el sistema.");
            return;
        }
        boolean registro = empresa.registrarServicio(new ServiciosAdicionales(
                codigo, nombre, descripcion, precio, disponibilidad
        ));

        if (registro) {
            mostrarMensaje("Servicio registrado exitosamente.");
        } else {
            mostrarMensaje("Sin espacio para más servicios.");
        }
    }
    private static void solicitarProyecto() {
        String cedula = pedirDatos("Ingrese la Cédula / NIT del cliente:");
        Cliente clienteEncontrado = empresa.buscarCliente(cedula);
        if (clienteEncontrado == null) {
            mostrarMensaje("El cliente no está registrado. Por favor regístrelo primero.");
            return;
        }
        boolean registro = empresa.registrarProyecto(
                new Proyecto(
                pedirDatos("Código:"),
                clienteEncontrado,
                LocalDate.parse(pedirDatos("Fecha Solicitud (ej: 2026-05-10):")),
                LocalDate.parse(pedirDatos("Fecha Inicio (ej: 2026-05-10):")),
                LocalDate.parse(pedirDatos("Fecha Entrega (ej: 2026-05-10):")),
                pedirDatos("Estado:"+"\n"+"Pendiente"+"\n"+"Confirmado"+"\n"+"En curso"+"\n"+
                        "Finalizado"+"\n"+"Cancelado"),
                pedirDatos("Método Pago"+"\n"+"Tarjeta"+"\n"+"Transferencia"+"\n"+"Efectivo"),
                Integer.parseInt(pedirDatos("Días de desarrollo estimado:")),
                Double.parseDouble(pedirDatos("Porcentaje de descuento (%):"))
        ));

        if (registro) {
            mostrarMensaje("Proyecto registrado exitosamente para " + clienteEncontrado.getNombre() + ".");
        } else {
            mostrarMensaje("Sin espacio para más proyectos.");
        }
    }
    private static void asignarDesarrollador() {
        boolean registro = empresa.asignarDesarrolladorAProyecto(
                pedirDatos("Código del proyecto:"),
                pedirDatos("Código del desarrollador:")
        );
        if (registro) {
            mostrarMensaje("Desarrollador asignado exitosamente al proyecto.") ;   
        }else{
            mostrarMensaje("No se pudo asignar. Verifique que el proyecto exista y que el desarrollador esté 'Disponible'.");;
        }
    }

    private static void asociarServicio() {
        boolean registro = empresa.asociarServicioAProyecto(
                pedirDatos("Código del proyecto:"),
                pedirDatos("Código del servicio adicional:")
        );
        if (registro) {
            mostrarMensaje("Servicio asociado exitosamente al proyecto ");
        } else{
            mostrarMensaje("No se pudo asociar el servicio. Verifique los códigos.");
        }

    }

    private static void cambiarEstadoProyecto() {
        boolean registro = empresa.cambiarEstadoProyecto(
                pedirDatos("Código del proyecto:"),
                pedirDatos("Nuevo Estado (Confirmado, En curso, Finalizado, Cancelado):")
        );
        if (registro) {
            mostrarMensaje("Estado actualizado correctamente.");
        }else{
            mostrarMensaje("Proyecto no encontrado.");
        }
    }

    private static void solicitarConsultarCliente() {
        String tel = pedirDatos("Ingrese teléfono del cliente a consultar:");
        Cliente cliente = empresa.consultarTelefonoCliente(tel);

        if (cliente != null) {
            String esNumPerfecto;

            if (empresa.esPerfecto(tel)) {
                esNumPerfecto = "Si";
            }else {
                esNumPerfecto = "No";
            }
            mostrarMensaje("Cliente encontrado:\n" +
                    "Nombre: " + cliente.getNombre() + "\n" +
                    "Cédula/NIT: " + cliente.getCedula() + "\n" +
                    "Teléfono: " + cliente.getTelefono() + "\n" +
                    "¿El teléfono es un Número Perfecto?: " + esNumPerfecto);
        } else {
            mostrarMensaje("No existe un cliente con el teléfono " + tel);
        }
    }

    private static void solicitarIngresosFecha() {
        LocalDate fecha = LocalDate.parse(pedirDatos("Ingrese fecha a consultar (ej: 2026-05-10):"));
        mostrarMensaje("El total de proyectos solicitados en " + fecha + " es: $" + empresa.calcularIngresoFecha(fecha));
    }

    private static void solicitarTotalProyecto() {
        String id = pedirDatos("Ingrese el código del proyecto:");
        double total = empresa.consultarTotalProyecto(id);
        if (total != -1) {
            mostrarMensaje("El valor total calculado para el proyecto (" + id + ") es: $" + total);
        } else {
            mostrarMensaje("Proyecto no encontrado.");
        }
    }

    private static String pedirDatos(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}