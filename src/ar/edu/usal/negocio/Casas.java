package ar.edu.usal.negocio;

import ar.edu.usal.utils.OrientacionENUM;

import java.io.Serializable;

public class Casas extends Construcciones implements Serializable {

    private static final long serialVersionUID = 3276682438954876504L;
    int ambientes;

    //Norte, Sur, Este u Oeste
    OrientacionENUM orientacion;


    public Casas(double superficiePorM2, String direccion, double precioPorM2, int ambientes, OrientacionENUM orientacion) {
        super(superficiePorM2, direccion, precioPorM2);
        this.ambientes = ambientes;
        this.orientacion = orientacion;
    }

    @Override
    public void mostrarCaracteristicas() {

        super.mostrarCaracteristicas();
        System.out.printf("Ambientes: %s m2. Orientacion : %s", ambientes, orientacion);
        System.out.println("Precio de la casa: " + calcularPrecioTotal(superficiePorM2, precioPorM2, ambientes));
    }

    public void updateAmbientes(int nuevosAmbientes) {
        this.ambientes = nuevosAmbientes;
    }

    public void updateOrientacion(OrientacionENUM nuevaOrientacion) {
        this.orientacion = nuevaOrientacion;
    }

    //Calcular el precio total
    public Double calcularPrecioTotal(Double superficiePorM2, Double precioPorM2, int ambientes) {
        return superficiePorM2 * precioPorM2 * ambientes;
    }
}

