package ar.edu.usal.utils;

import ar.edu.usal.negocio.Casas;
import ar.edu.usal.negocio.Edificios;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/*
 * Contiene distintos métodos para poder realizar el manejo de archivos. Crear, Editar,Listar, Leer contenido
 */
public class ArchivosUtils {


    /*
     * Se crea el archivo txt. Pide ingresar solo el nombre de archivo. EL sistema le carga la fecha y el tipo de dato automaticamente.
     */
    public static void crearFile(Edificios edificio, Casas casa, boolean esEdicion, String nombreConstruccion) throws IOException {
        Scanner scan = new Scanner(System.in);

        if (!esEdicion) {
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

                System.out.println("El objeto se ha guardado en el archivo " + fileName);
            }
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(nombreConstruccion + ".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(edificio);
            System.out.println("Se ha editado el archivo " + nombreConstruccion);
        }


    }

    /**
     * Crear un archivo. Recibe como parametro la lista de las casas y edificios construidos.
     *
     * @param construccion
     * @throws IOException
     */
    public static void crearFile(List<Object> construccion) throws IOException {

        if (construccion.size() != 0) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Ingresar nombre de la construccion");
            if (scan.hasNext()) {
                String fileName = scan.next() + "_" + DateUtils.formatFecha() + ".txt";

                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(construccion);

                objectOutputStream.close();
                fileOutputStream.close();

                System.out.println("El objeto se ha guardado en el archivo " + fileName);
            }
        } else {
            System.out.println("No se ha creado el archivo ya que no hay informacion cargada.");
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

                System.out.println("Información del edificio " + nombreConstruccion);
                edificio.mostrarCaracteristicas();
            } else {
                Casas casa = (Casas) objectInputStream.readObject();

                System.out.println("Información de la casa " + nombreConstruccion);
                casa.mostrarCaracteristicas();
            }

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void leerContenidoArchivo(String nombreConstruccion) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreConstruccion + ".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //Uso una lista de objetos porque en el For puede venir un objeto de tipo Edificios o un objeto de tipo Casas
            List<Object> list = (List<Object>) objectInputStream.readObject();

            System.out.println("Listando el contenido de " + nombreConstruccion);
            //Uso instance of para verificar que el tipo de cada elemento del array. Si no es de tipo Casas, se que va a ser de tipo Edificios.
            for (Object o : list) {
                if (o instanceof Casas) {
                    Casas casa = (Casas) o;
                    System.out.println("**** Casa ****");
                    casa.mostrarCaracteristicas();
                } else {
                    System.out.println("**** Edificio ****");
                    Edificios edificio = (Edificios) o;
                    edificio.mostrarCaracteristicas();
                }
            }

            System.out.println("Información de la casa " + nombreConstruccion);

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * Busca el la carpeta del proyecto los archivos .txt creados. Si encuentra, va haciendo un sysout
     */
    public static void listarConstruciones() {
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


    public static Casas obtenerCasa(String nombreConstruccion) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nombreConstruccion + ".txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Casas) objectInputStream.readObject();
    }

    public static Edificios obtenerEdificio(String nombreConstruccion) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nombreConstruccion + ".txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Edificios) objectInputStream.readObject();
    }
}
