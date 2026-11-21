package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Mecanico;
import modelo.Vehiculo;

public class ControladorTaller {

    public ArrayList<Mecanico> cargarDatos() throws IOException {

        ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        BufferedReader archivo1 = new BufferedReader(
                new FileReader("mecanicos.txt"));

        String linea;

        while ((linea = archivo1.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                mecanicos.add(new Mecanico(linea.trim()));
            }
        }

        archivo1.close();

        BufferedReader archivo2 = new BufferedReader(
                new FileReader("vehiculos.txt"));

        while ((linea = archivo2.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                String[] datos = linea.split(",");

                if (datos.length != 2) {
                    archivo2.close();
                    throw new IOException("Formato incorrecto en vehiculos.txt");
                }

                vehiculos.add(new Vehiculo(
                        datos[0].trim(), datos[1].trim()));
            }
        }

        archivo2.close();

        if (mecanicos.size() != 10 || vehiculos.size() != 50) {
            throw new IOException(
                    "Se necesitan 10 mecanicos y 50 vehiculos");
        }

        int posicion = 0;

        for (Mecanico mecanico : mecanicos) {
            for (int i = 0; i < 5; i++) {
                mecanico.agregarVehiculo(vehiculos.get(posicion));
                posicion++;
            }
        }

        return mecanicos;
    }

    public int contarErrores(Vehiculo vehiculo) {
        int errores = 0;

        if (vehiculo.getLambda() > 1) {
            errores++;
        }

        if (vehiculo.getO2() >= 2) {
            errores++;
        }

        if (vehiculo.getN2o() >= 40) {
            errores++;
        }

        if (vehiculo.getCo2() >= 15) {
            errores++;
        }

        return errores;
    }

    public double[] calcularPorcentajes(Mecanico mecanico) {

        int[] errores = new int[4];
        int totalErrores = 0;

        for (Vehiculo vehiculo : mecanico.getVehiculos()) {

            if (vehiculo.getLambda() > 1) {
                errores[0]++;
            }

            if (vehiculo.getO2() >= 2) {
                errores[1]++;
            }

            if (vehiculo.getN2o() >= 40) {
                errores[2]++;
            }

            if (vehiculo.getCo2() >= 15) {
                errores[3]++;
            }

            totalErrores += contarErrores(vehiculo);
        }

        double[] porcentajes = new double[5];
        int cantidad = mecanico.getVehiculos().size();

        for (int i = 0; i < 4; i++) {
            porcentajes[i] = errores[i] * 100.0 / cantidad;
        }

        porcentajes[4] = totalErrores * 100.0 / (cantidad * 4);

        return porcentajes;
    }

    public String obtenerResultado(double[] porcentajes) {

        if (porcentajes[0] <= 70 &&
            porcentajes[1] <= 30 &&
            porcentajes[2] <= 80 &&
            porcentajes[3] <= 50) {

            return "Pasa en Primera Revision";
        }

        return "Segunda Revision Asignada";
    }
}

