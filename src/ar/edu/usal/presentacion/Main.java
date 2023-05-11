package ar.edu.usal.presentacion;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.Edificios;
import ar.edu.usal.utils.DateUtils;
import ar.edu.usal.utils.OrientacionENUM;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.bind.ValidationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * Comienza con el menu principal.
 * Hay 3 opciones: Crear, Listar construcciones y salir.
 * Falta agregar la de editar
 */

public class Main {
    public static void main(String[] args) throws IOException, ValidationException {
        Scanner scan = new Scanner(System.in);

        System.out.println("******* Ingresar una opcion *******");
        System.out.println("1. Crear construccion");
        System.out.println("2. Listar construcciones");
        System.out.println("3. Listar informacino de una construccion");
        System.out.println("4. Salir");

        int opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Crear Construccion");
                crearConstruccion();
                break;
            case 2:
                System.out.println("Listar construcciones");
                listarArchivosTxt();
                break;
            case 3:
                System.out.println("Ver informacion de una construccion");
                cargarMenuListarContenido();
                break;
            case 4:
                System.out.println("******* Proceso Finalizado *******");
                break;
            default:
                System.out.println("La opcion no se encuentra disponible.");
                main(null);
        }
    }

    public static void crearConstruccion() throws IOException, ValidationException {
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

    public static void cargarNuevoEdificio() throws IOException {
        Edificios edificio = new Edificios(123.3, "", 123.3, 1, 1);

        crearFile(edificio, null);
    }

    public static void cargarMenuListarContenido() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresar el nombre de la construccion y la fecha que desea buscar. ");
        System.out.println("El formato es construc_ddMMyyyy. Por ejemplo CasaNorte01012023");
        String nombreArchivo = scan.next();
        System.out.println("Ingresar el tipo de construccion. 1. Edificio 2.Casa");
        String tipo = scan.next();

        leerContenidoArchivo(tipo, nombreArchivo);
    }


    public static void cargarNuevaCasa() throws IOException, ValidationException {
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

        Casas casa = new Casas(superficie, "", precioPorM2, ambientes, OrientacionENUM.getByDescription(orientacion.toUpperCase()));
        crearFile(null, casa);
    }

    public static void crearFile(Edificios edificio, Casas casa) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar nombre del edificio o casa");
        if (scan.hasNext()) {
            String fileName = scan.next() + DateUtils.formatFecha() + ".txt";

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            if (edificio != null) {
                objectOutputStream.writeObject(edificio);
            } else {
                objectOutputStream.writeObject(casa);
            }

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("El objeto Edificio se ha guardado en el archivo " + fileName);
        }

    }

    public static void leerContenidoArchivo(String tipo, String nombreConstruccion) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreConstruccion);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            if (tipo.equalsIgnoreCase("edificio")) {
                Edificios edificio = (Edificios) objectInputStream.readObject();

                System.out.println("Información del edificio:");
                System.out.println("Pisos: " + edificio.getPisos());
                System.out.println("Unidades: " + edificio.getUnidades());
            } else {
                Casas casa = (Casas) objectInputStream.readObject();

                System.out.println("Información de la casa:");
                System.out.println("Ambientes: " + casa.getAmbientes());
                System.out.println("Orientacion: " + casa.getOrientacion());
            }

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void listarArchivosTxt() {
        File carpeta = new File(System.getProperty("user.dir"));
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                    System.out.println(archivo.getName());
                }
            }
        }
    }
}
