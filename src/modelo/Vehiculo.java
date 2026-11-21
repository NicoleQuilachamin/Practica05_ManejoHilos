package modelo;

public class Vehiculo {

    private String marca;
    private String placa;
    private double lambda;
    private double o2;
    private double n2o;
    private double co2;

    public Vehiculo(String marca, String placa) {
        this.marca = marca;
        this.placa = placa;

        lambda = 0.8 + Math.random() * 0.4;
        o2 = Math.random() * 4;
        n2o = 20 + Math.random() * 40;
        co2 = 10 + Math.random() * 10;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public double getLambda() {
        return lambda;
    }

    public double getO2() {
        return o2;
    }

    public double getN2o() {
        return n2o;
    }

    public double getCo2() {
        return co2;
    }
}
