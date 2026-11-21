package hilos;

import modelo.Mecanico;
import controlador.ControladorTaller;
import vista.VistaConsola;

public class HiloMecanico implements Runnable {

    private Mecanico mecanico;
    private ControladorTaller controlador;
    private VistaConsola vista;

    public HiloMecanico(Mecanico mecanico,
            ControladorTaller controlador, VistaConsola vista) {

        this.mecanico = mecanico;
        this.controlador = controlador;
        this.vista = vista;
    }

    @Override
    public void run() {

        double[] porcentajes =
                controlador.calcularPorcentajes(mecanico);

        String resultado =
                controlador.obtenerResultado(porcentajes);

        vista.mostrarTabla(mecanico, controlador,
                porcentajes, resultado);
    }
}
