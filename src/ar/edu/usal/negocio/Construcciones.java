package ar.edu.usal.negocio;

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
        System.out.println("Superfie por M2:" + superficiePorM2);
        System.out.println("Direccion: " + direccion);
        System.out.println("Precio por M2: $" + precioPorM2);
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


}
