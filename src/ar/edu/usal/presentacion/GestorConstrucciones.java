package ar.edu.usal.presentacion;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.Edificios;

import java.util.ArrayList;
import java.util.Scanner;

import static ar.edu.usal.utils.ArchivosUtils.crearFile;
import static ar.edu.usal.utils.ArchivosUtils.leerContenidoArchivo;

public class GestorConstrucciones {

    public static void crearConstruccion() throws Exception {

        //Inicializo el array que va a tener las construcciones hechas para poder crear el file.
        ArrayList<Object> construccionesList = new ArrayList<>();

        //Inicializo el scanner para poder tener los inputs del teclado.
        Scanner scan = new Scanner(System.in);

        //Llamo al metodo para poder comenzar a crear los edificios y las casas.
        menuCrear(construccionesList, scan);
    }

    private static void menuCrear(ArrayList<Object> construccionesList, Scanner scan) throws Exception {
        int number = validarInputEntero(scan);
        switch (number) {
            case 1:
                Edificios edificio = GestorEdificios.cargarNuevoEdificio();
                construccionesList.add(edificio);
                menuCrear(construccionesList, scan);
                break;
            case 2:
                Casas casa = GestorCasas.cargarNuevaCasa();
                construccionesList.add(casa);
                menuCrear(construccionesList, scan);
                break;
            case 3:
                crearFile(construccionesList);
                Main.main(null);
                break;
            default:
                System.out.println("Opcion incorrecta. Debe ingresar un numero del listado.");
                menuCrear(construccionesList, scan);
                break;
        }
    }

    //Obtener la informacion de una construccion.
    public static void cargarMenuListarContenido() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar el nombre de la construccion y la fecha que desea buscar. \nEl formato es construc_ddMMyyyy. Por ejemplo CasaNorte_01012023.");
        String nombreArchivo = scan.next();
        leerContenidoArchivo(nombreArchivo);
    }

    /**
     * Validar que el input no sea nulo ni un caracter.
     *
     * @param scan
     * @return number
     */
    private static int validarInputEntero(Scanner scan) {
        int number;
        do {
            System.out.println("¿Que desea agregar? \n 1. Edificio \n 2. Casa \n 3. Registrar construccion.");
            while (!scan.hasNextInt()) {
                System.out.println("Input incorrecto. Debe ingresar un numero.");
                scan.next();
            }
            number = scan.nextInt();
        } while (number <= 0);
        return number;
    }

}
