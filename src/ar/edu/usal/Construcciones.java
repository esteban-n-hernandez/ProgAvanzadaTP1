package ar.edu.usal;

public abstract class Construcciones {

    Double superficiePorM2;
    String direccion;
    Double precioPorM2;


    public Construcciones(Double superficiePorM2, String direccion, Double precioPorM2) {
        this.superficiePorM2 = superficiePorM2;
        this.direccion = direccion;
        this.precioPorM2 = precioPorM2;
    }

    public void mostrarCaracteristicas() {
        System.out.printf("Superfie por M2: %s m2. Direccion: %s, Precio por M2: %s", superficiePorM2, direccion, precioPorM2);
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
