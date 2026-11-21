package hilos;

import modelo.Mecanico;
import controlador.ControladorTaller;
import vista.VistaConsola;

public class HiloCargaDatos extends Thread {

    private Mecanico mecanico;
    private ControladorTaller controlador;
    private VistaConsola vista;

    public HiloCargaDatos(Mecanico mecanico,
            ControladorTaller controlador, VistaConsola vista) {

        this.mecanico = mecanico;
        this.controlador = controlador;
        this.vista = vista;
    }

    @Override
    public void run() {

        try {

            int tiempo = (int) (Math.random() * 3001);

            Thread.sleep(tiempo);

            HiloMecanico trabajo = new HiloMecanico(
                    mecanico, controlador, vista);

            Thread hilo = new Thread(trabajo);
            hilo.start();
            hilo.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

