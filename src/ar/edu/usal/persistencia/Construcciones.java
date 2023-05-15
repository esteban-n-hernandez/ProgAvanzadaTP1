package ar.edu.usal.persistencia;

import java.io.Serializable;

public abstract class Construcciones implements Serializable {

    private static final long serialVersionUID = -2630730089336095297L;
    Double superficiePorM2;
    String direccion;
    Double precioPorM2;


    public Construcciones(Double superficiePorM2, String direccion, Double precioPorM2) {
        this.superficiePorM2 = superficiePorM2;
        this.direccion = direccion;
        this.precioPorM2 = precioPorM2;
    }

    public void mostrarCaracteristicas() {
        System.out.printf("Superfie por M2: %s%nDireccion: %s%nPrecio por M2: %s%n", superficiePorM2, direccion, precioPorM2);
    }

    public void updateSuperficie(double nuevaSuperficie) {
        superficiePorM2 = nuevaSuperficie;
    }

    public void updateDireccion(String nuevaDireccion) {
        direccion = nuevaDireccion;
    }

    public void updatePrecio(double nuevoPrecio) {
        precioPorM2 = nuevoPrecio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getPrecioPorM2() {
        return precioPorM2;
    }

    public void setPrecioPorM2(Double precioPorM2) {
        this.precioPorM2 = precioPorM2;
    }
}
