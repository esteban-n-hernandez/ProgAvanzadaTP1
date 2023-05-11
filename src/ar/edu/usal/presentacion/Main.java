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

public class Main {
    public static void main(String[] args) throws IOException, ValidationException {
        Scanner scan = new Scanner(System.in);

        System.out.println("******* Ingresar una opcion *******");
        System.out.println("1. Crear construccion");
        System.out.println("2. Listar construcciones");
        System.out.println("3. Salir");

        int opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Crear Construccion");
                crearConstruccion();
                break;
            case 2:
                System.out.println("Listar construcciones");
                listarConstrucciones();
                break;
            case 3:
                System.out.println("******* Proceso Finalizado *******");
                break;
            default:
                System.out.println("La opcion no se encuentra disponible.");
                main(null);
        }
    }

    private static void listarConstrucciones() {
        System.out.println(listarArchivosTxt());
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

    public static void leerContenidoArchivo(String nombreConstruccion) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreConstruccion);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Edificios edificio = (Edificios) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Información del edificio:");
            System.out.println("Pisos: " + edificio.getPisos());
            System.out.println("Unidades: " + edificio.getUnidades());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> listarArchivosTxt() {
        List<String> archivosTxt = new ArrayList<>();

        File carpeta = new File(System.getProperty("user.dir"));
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                    archivosTxt.add(archivo.getName());
                }
            }
        }
        return archivosTxt;
    }
}
