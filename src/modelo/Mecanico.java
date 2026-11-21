package modelo;

import java.util.ArrayList;

public class Mecanico {

    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Mecanico(String nombre) {
        this.nombre = nombre;
        vehiculos = new ArrayList<Vehiculo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
