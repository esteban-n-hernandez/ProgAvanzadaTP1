package ar.edu.usal.presentacion;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.enums.OrientacionENUM;

import java.util.Scanner;

import static ar.edu.usal.utils.ArchivosUtils.crearFile;

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

        Casas casa = new Casas(superficie, direccion, precioPorM2, ambientes, OrientacionENUM.getByDescription(orientacion.toUpperCase()));
  //      crearFile(null, casa, false, null);
    return casa;
    }
}
