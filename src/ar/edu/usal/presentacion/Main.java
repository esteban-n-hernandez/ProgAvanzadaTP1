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
        int opcion = validarInputEntero(scan);

        switch (opcion) {
            case 1:
                GestorConstrucciones.crearConstruccion();
                break;
            case 2:
                listarConstruciones();
                break;
            case 3:
                GestorConstrucciones.cargarMenuListarContenido();
                break;
            case 4:
                editarInformacion();
                break;
            case 5:
                System.out.println("******* Proceso Finalizado *******");
                break;
            default:
                System.out.println("La opcion no se encuentra disponible.");
                main(null);
        }
    }


    //TODO Eliminarlo, no esta en la consigna.
    private static void editarInformacion() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la construcción que desea editar");
        listarConstruciones();
        System.out.println("Nombre: ");
        String nombreConstruccion = scan.next();

        System.out.println("Ingresar tipo de construcción: 1. Edificio o 2. Casa");
        String tipoConstruccion = scan.next();

        if (tipoConstruccion.equals("Edificio") || tipoConstruccion.equals("1")) {
            Edificios edificioAEditar = obtenerEdificio(nombreConstruccion);

            if (edificioAEditar != null) {
                System.out.println("Solo puede editar la cantidad de pisos o unidades.");

                System.out.println("Ingrese cantidad de pisos: ");
                edificioAEditar.actualizarPisos(scan.nextInt());

                System.out.println("Ingrese cantidad de unidades: ");
                edificioAEditar.actualizarUnidades(scan.nextInt());

                crearFile(edificioAEditar, null, true, nombreConstruccion);
            } else {
                System.out.println("No se encontro el edificio cargado. ");
            }
        } else {
            Casas casaAEditar = obtenerCasa(nombreConstruccion);

            if (casaAEditar != null) {
                System.out.println("Solo puede editar la cantidad de ambientes y la orientacion.");

                System.out.println("Ingresar cantidad de ambientes: ");
                casaAEditar.updateAmbientes(scan.nextInt());

                System.out.println("Ingresar nueva orientacion: ");
                casaAEditar.updateOrientacion(OrientacionENUM.getByDescription(scan.next().toUpperCase()));

                crearFile(null, casaAEditar, true, nombreConstruccion);
            } else {
                System.out.println("No se encontro la casa cargada");
            }
        }
    }


    private static int validarInputEntero(Scanner scan) {
        int number;
        do {
            System.out.println("**************************");
            System.out.println("1. Crear construccion \n2. Listar construcciones \n3. Listar informacion de una construccion \n4. Editar informacion de construccion \n5. Salir");
            System.out.println("**************************");
            while (!scan.hasNextInt()) {
                System.out.println("Input incorrecto. Debe ingresar un numero.");
                scan.next();
            }
            number = scan.nextInt();
        } while (number <= 0);
        return number;
    }
}
