import ar.edu.usal.Casas;
import ar.edu.usal.Edificios;
import ar.edu.usal.OrientacionENUM;

public class Main {
    public static void main(String[] args) {

        //El constructor pide si o si que se le pasen parametros, asi que hay que ponerle.
        Edificios edificio1 = new Edificios(123.3, "", 123.3, 1, 1);

        Casas casa1 = new Casas(1, "", 1, 1, OrientacionENUM.ESTE);

        //Muestra las caracteristicas del Edificio
        edificio1.mostrarCaracteristicas();

        //update direccion del edificio
        edificio1.updateDireccion("Cesar Diaz 1440, Escobar");
        //update precio del edificio
        edificio1.updatePrecio(25000);
        //update superficie del edificio
        edificio1.updateSuperficie(150);


        //update orientacion de la casa
        casa1.updateOrientacion(OrientacionENUM.NORTE);

        //update cantidad de ambientes de la casa
        casa1.updateAmbientes(4);


    }
}
