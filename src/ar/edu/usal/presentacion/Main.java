package ar.edu.usal.presentacion;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.Edificios;
import ar.edu.usal.utils.DateUtils;
import ar.edu.usal.utils.OrientacionENUM;

import java.io.*;
import java.util.Scanner;


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

    public static void crearFile(Edificios edificio, Casas casa) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar nombre del edificio o casa");
        if (scan.hasNext()) {
            String fileName = scan.next() + "_" + DateUtils.formatFecha() + ".txt";

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

    /*
     * Recibe el tipo y el nombre de la construccion. Si es edificio, llama al método mostrar carcateristica para traer los datos de la construccio.
     * Después se hace un get pisos y get unidades para mostrar la información de ese edificio.
     * Con las caseas es lo mismo. Primero se obtiene las caracteristicas de la construcion y luego  se obtiene el ambiente y la orientación.
     */
    public static void leerContenidoArchivo(String tipo, String nombreConstruccion) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreConstruccion + ".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            if (tipo.equalsIgnoreCase("edificio") || tipo.equals("1")) {
                Edificios edificio = (Edificios) objectInputStream.readObject();

                System.out.println("Información del edificio:");
                edificio.mostrarCaracteristicas();
            } else {
                Casas casa = (Casas) objectInputStream.readObject();

                System.out.println("Información de la casa:");
                casa.mostrarCaracteristicas();
            }

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * Busca el la carpeta del proyecto los archivos .txt creados. Si encuentra, va haciendo un sysout
     */
    public static void listarArchivosTxt() {
        System.out.println("Construciones registradas: ");
        File carpeta = new File(System.getProperty("user.dir"));
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                    System.out.println(". " + archivo.getName().replace(".txt", ""));
                }
            }
        }
    }
}
