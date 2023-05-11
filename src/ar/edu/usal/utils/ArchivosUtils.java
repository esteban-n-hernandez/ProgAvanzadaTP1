package ar.edu.usal.utils;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.Edificios;

import java.io.*;
import java.util.Scanner;

/*
 * Contiene distintos métodos para poder realizar el manejo de archivos. Crear, Editar,Listar, Leer contenido
 */
public class ArchivosUtils {


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

    public static void editarFile() {

    }
}
