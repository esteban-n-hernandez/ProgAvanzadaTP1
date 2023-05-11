package ar.edu.usal.presentacion;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.Edificios;
import ar.edu.usal.negocio.enums.OrientacionENUM;

import java.util.Scanner;

import static ar.edu.usal.utils.ArchivosUtils.*;


/*
 * Comienza con el menu principal.
 * Hay 3 opciones: Crear, Listar construcciones y salir.
 * Falta agregar la de editar
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("**************************");
        System.out.println("1. Crear construccion");
        System.out.println("2. Editar informacion de construccion");
        System.out.println("3. Listar construcciones");
        System.out.println("4. Listar informacion de una construccion");
        System.out.println("5. Salir");
        System.out.println("**************************");

        int opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Crear Construccion");
                crearConstruccion();
                break;
            case 2:
                editarInformacion();
                main(null);
                break;
            case 3:
                listarArchivosTxt();
                main(null);
                break;
            case 4:
                System.out.println("Ver informacion de una construccion");
                cargarMenuListarContenido();
                main(null);
                break;
            case 5:
                System.out.println("******* Proceso Finalizado *******");
                break;
            default:
                System.out.println("La opcion no se encuentra disponible.");
                main(null);
        }
    }

    private static void editarInformacion() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la construcción que desea editar");
        listarArchivosTxt();
        System.out.println("Nombre: ");
        scan.next();

        editarArchivo();

    }

    //TODO Crear logica para editar el file
    private static void editarArchivo() {

        System.out.println("Construccino modificada");
    }

    public static void crearConstruccion() throws Exception {
        System.out.println("******* Seleccionar tipo de construccion *******");
        System.out.println("1. Edificio");
        System.out.println("2. Casa");

        Scanner scan = new Scanner(System.in);
        int opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Entrando al menu para cargar los datos del nuevo edificio");
                cargarNuevoEdificio();
                break;
            case 2:
                System.out.println("Entrando al menu para cargar los datos de la nueva casa");
                cargarNuevaCasa();
                break;
            default:
                System.out.println("La opcion no se encuentra disponible.");
                crearConstruccion();
        }
    }

    public static void cargarNuevoEdificio() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar los datos: ");

        System.out.println("Superficie M2: ");
        double superficie = scan.nextDouble();

        System.out.println("precioPorM2: ");
        double precioPorM2 = scan.nextDouble();

        System.out.println("Pisos: ");
        int pisos = scan.nextInt();

        System.out.println("Unidades: ");
        int unidades = scan.nextInt();

        System.out.println("Direccion: ");
        String direccion = scan.next();


        Edificios edificio = new Edificios(superficie, direccion, precioPorM2, pisos, unidades);

        crearFile(edificio, null);
    }

    public static void cargarMenuListarContenido() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresar el nombre de la construccion y la fecha que desea buscar. ");
        System.out.println("El formato es construc_ddMMyyyy. Por ejemplo CasaNorte_01012023");
        String nombreArchivo = scan.next();
        System.out.println("Ingresar el tipo de construccion. 1. Edificio  o 2.Casa");
        String tipo = scan.next();

        leerContenidoArchivo(tipo, nombreArchivo);
    }


    public static void cargarNuevaCasa() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar los datos: ");

        System.out.println("Superficie M2: ");
        double superficie = scan.nextDouble();

        System.out.println("precioPorM2: ");
        double precioPorM2 = scan.nextDouble();

        System.out.println("Ambientes: ");
        int ambientes = scan.nextInt();

        System.out.println("Orientacion: Debe ser Norte, Sur, Este u Oeste ");
        String orientacion = scan.next();

        System.out.println("Orientacion: Debe ser Norte, Sur, Este u Oeste ");
        String direccion = scan.next();

        Casas casa = new Casas(superficie, direccion, precioPorM2, ambientes, OrientacionENUM.getByDescription(orientacion.toUpperCase()));
        crearFile(null, casa);
    }


}
