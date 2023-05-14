package ar.edu.usal.negocio;

import ar.edu.usal.persistencia.Casas;
import ar.edu.usal.persistencia.enums.OrientacionENUM;

import java.util.Scanner;

public class GestorCasas {

    public static Casas cargarNuevaCasa() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar los datos: ");

        System.out.println("Superficie M2: ");
        double superficie = scan.nextDouble();

        System.out.println("Precio por M2: ");
        double precioPorM2 = scan.nextDouble();

        System.out.println("Ambientes: ");
        int ambientes = scan.nextInt();

        System.out.println("Orientacion: Debe ser Norte, Sur, Este u Oeste:  ");
        String orientacion = scan.next();

        System.out.println("Direccion: ");
        String direccion = scan.next();

        return new Casas(superficie, direccion, precioPorM2, ambientes, OrientacionENUM.getByDescription(orientacion.toUpperCase()));
    }
}
