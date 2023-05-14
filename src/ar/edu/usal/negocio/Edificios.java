package ar.edu.usal.negocio;

import java.io.Serializable;

public class Edificios extends Construcciones implements Serializable {
    private static final long serialVersionUID = -8854177116901404963L;
    private int pisos;
    private int unidades;

    public Edificios(double superficiePorM2, String direccion, double precioPorM2, int pisos, int unidades) {
        super(superficiePorM2, direccion, precioPorM2);
        this.pisos = pisos;
        this.unidades = unidades;
    }

    @Override
    public void mostrarCaracteristicas() {
        super.mostrarCaracteristicas();
        System.out.printf("Pisos: %s%nUnidades: %s%nPrecio del edificio: %s", pisos, unidades, calcularPrecioTotal(superficiePorM2, precioPorM2, unidades));
    }

    public void actualizarPisos(int nuevosPisos) {
        this.pisos = nuevosPisos;
    }

    public void actualizarUnidades(int nuevasUnidades) {
        this.unidades = nuevasUnidades;
    }

    //Calcular el precio total
    public Double calcularPrecioTotal(Double superficiePorM2, Double precioPorM2, int unidades) {
        return superficiePorM2 * precioPorM2 * unidades;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}

