package ar.edu.usal.presentacion;

import java.util.Scanner;


/*
 * Comienza con el menu principal.
 * Hay 4 opciones: Crear, Listar construcciones, Listar el contenido de alguna construccion, Salir. .
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int opcion = validarInputEntero(scan);

        switch (opcion) {
            case 1:
                MenuConstrucciones.crearConstruccion();
                break;
            case 2:
                MenuConstrucciones.listarConstruciones();
                break;
            case 3:
                MenuConstrucciones.cargarMenuListarContenido();
                break;
            case 4:
                System.out.println("******* Proceso Finalizado *******");
                break;
            default:
                System.out.println("La opcion no se encuentra disponible.");
                main(null);
        }
    }

    private static int validarInputEntero(Scanner scan) {
        int number;
        do {
            System.out.println("**************************");
            System.out.println("1. Crear construccion \n2. Listar construcciones creadas \n3. Listar informacion de una construccion \n4. Salir");
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
