package app;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Mecanico;
import controlador.ControladorTaller;
import hilos.HiloCargaDatos;
import vista.VistaConsola;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ControladorTaller controlador = new ControladorTaller();
        VistaConsola vista = new VistaConsola();

        try {

            ArrayList<Mecanico> mecanicos = controlador.cargarDatos();
            ArrayList<HiloCargaDatos> hilos =
                    new ArrayList<HiloCargaDatos>();

            System.out.println("SISTEMA DE REVISION VEHICULAR");
            System.out.println("Cargando datos de los mecanicos...");

            for (Mecanico mecanico : mecanicos) {

                HiloCargaDatos hilo = new HiloCargaDatos(
                        mecanico, controlador, vista);

                hilos.add(hilo);
                hilo.start();
            }

            for (HiloCargaDatos hilo : hilos) {
                hilo.join();
            }

            System.out.println();
            System.out.println("Todos los mecanicos terminaron su trabajo.");

        } catch (IOException e) {
            System.out.println("Error al leer archivos: " + e.getMessage());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
