package co.edu.uniquindio;
import javax.swing.*;

public class Main {
    private static EmpresaDevPlus empresa;

    public static void main (String[] args){
        empresa = new EmpresaDevPlus("18272026-02", "DevPlus", "Calle 10 #23 - 14", "3219393229", "www.devplus.com");
        int opcion = 0;

        do {
            String menu = " ⋆˚｡⋆ Menu devplus ⋆˚｡⋆ \n" +
                    "⋅♡ Selecciona una opcion del siguiente menu: ♡⋅" +
                    "1. Registar cliente \n " +
                    "2. Registar desarrollador \n" +
                    "3. Registar servicio adicional \n" +
                    "4. Registar proyecto \n" +
                    "5. Asignar desarrallador a un proyecto \n" +
                    "6. Asociar servicio adicional a un proyecto \n" +
                    "7. Consultar cliente por telefono \n" +
                    "8. Cambiar estado de proyecto \n" +
                    "9. Calcular ingresos por fecha \n" +
                    "10.Mostar todos los proyectos \n" +
                    "11. Consultar Valor Total de un Proyecto\n" +
                    "0. Salir del menu ";
            String mostrarMenu = JOptionPane.showInputDialog(menu);
            if (mostrarMenu == null) {
                return;
            }
            opcion = Integer.parseInt(mostrarMenu);

            switch (opcion){
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
                    asignarDesarrallador();
                    break;
                case 6:
                    asociarServicio();
                    break;
                case 7:
                    consultarCliente();
                    break;
                case 8:
                    cambiarEstadoProyecto();
                    break;
                case 9:
                    solicitarIngresosFecha();
                    break;
                case 10:
                    String listaProyectos = empresa.mostarProyecto();
                    JOptionPane.showMessageDialog(null,lista);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"༺ Programa finalizado ༻");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Por favor ingresa una opcion valida");
                    break;
            }
        }
        while (opcion!=0);
    }


}
