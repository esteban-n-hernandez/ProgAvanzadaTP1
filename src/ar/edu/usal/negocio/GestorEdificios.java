package ar.edu.usal.negocio;

import ar.edu.usal.persistencia.Edificios;

import java.util.Scanner;


public class GestorEdificios {

    public static Edificios cargarNuevoEdificio() {

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

        return new Edificios(superficie, direccion, precioPorM2, pisos, unidades);
    }
}
