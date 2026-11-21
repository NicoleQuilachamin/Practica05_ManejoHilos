package vista;

import modelo.Mecanico;
import modelo.Vehiculo;
import controlador.ControladorTaller;

public class VistaConsola {

    public synchronized void mostrarTabla(Mecanico mecanico,
            ControladorTaller controlador,
            double[] porcentajes, String resultado) {

        System.out.println();
        System.out.println("MECANICO: " + mecanico.getNombre());
        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("%-14s %-12s %8s %8s %8s %8s %10s%n",
                "Marca", "Placa", "Lambda", "O2",
                "N2O", "CO2", "% Error");

        System.out.println("--------------------------------------------------------------------------------");

        for (Vehiculo vehiculo : mecanico.getVehiculos()) {

            double error = controlador.contarErrores(vehiculo) * 25.0;

            System.out.printf(
                    "%-14s %-12s %8.2f %8.2f %8.2f %8.2f %9.0f%%%n",
                    vehiculo.getMarca(),
                    vehiculo.getPlaca(),
                    vehiculo.getLambda(),
                    vehiculo.getO2(),
                    vehiculo.getN2o(),
                    vehiculo.getCo2(),
                    error);
        }

        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("Error Lambda: %.0f%%%n", porcentajes[0]);
        System.out.printf("Error O2: %.0f%%%n", porcentajes[1]);
        System.out.printf("Error N2O: %.0f%%%n", porcentajes[2]);
        System.out.printf("Error CO2: %.0f%%%n", porcentajes[3]);
        System.out.printf("Error general del lote: %.0f%%%n", porcentajes[4]);

        System.out.println("Resultado: " + resultado);
        System.out.println("================================================================================");
    }
}
