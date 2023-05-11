import ar.edu.usal.Construcciones;
import ar.edu.usal.Edificios;

public class Main {
    public static void main(String[] args) {

        //El constructor pide si o si que se le pasen parametros, asi que hay que ponerle.
        Edificios edificios = new Edificios(123.3, "", 123.3, 1, 1);

        //Muestra las caracteristicas del Edificio
        edificios.mostrarCaracteristicas();

        //update direccion del edificio
        edificios.updateDireccion("Cesar Diaz 1440, Escobar");
        //update precio del edificio
        edificios.updatePrecio(25000);
        //update superficie del edificio
        edificios.updateSuperficie(150);

    }
}
