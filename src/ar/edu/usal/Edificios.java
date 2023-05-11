package ar.edu.usal;

public class Edificios extends Construcciones {
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
        System.out.printf("Pisos: %s m2. Unidades: %s, Precio por M2: %s", pisos, unidades, precioPorM2);
        System.out.println("Precio del edificio: " + calcularPrecioTotal(superficiePorM2, precioPorM2, unidades));
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
}

