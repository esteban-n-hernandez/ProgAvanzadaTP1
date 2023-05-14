package ar.edu.usal.negocio;

import ar.edu.usal.persistencia.Casas;
import ar.edu.usal.persistencia.Construcciones;
import ar.edu.usal.persistencia.Edificios;
import ar.edu.usal.utils.DateUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static ar.edu.usal.utils.ArchivosUtils.crearFile;
import static ar.edu.usal.utils.ArchivosUtils.leerContenidoArchivo;

public class GestorConstrucciones {

    /**
     * Crea un nuevo edificio y lo agrega a la lista de construcciones.
     *
     * @param construccionesList
     */
    public static void crearEdificio(ArrayList<Object> construccionesList) {
        Edificios edificio = GestorEdificios.cargarNuevoEdificio();
        construccionesList.add(edificio);
    }

    /**
     * Crea una nueva casa y lo agrega a la lista de construcciones.
     *
     * @param construccionesList
     */
    public static void crearCasa(ArrayList<Object> construccionesList) throws Exception {
        Casas casa = GestorCasas.cargarNuevaCasa();
        construccionesList.add(casa);
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

    public static void leerContenidoArchivo(String nombreConstruccion) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreConstruccion + ".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //Uso una lista de objetos porque el For puede obtener un objeto de tipo Edificios o un objeto de tipo Casas
            List<Object> list = (List<Object>) objectInputStream.readObject();

            System.out.println("Listando el contenido de " + nombreConstruccion.toUpperCase());
            //Uso instanceof para verificar el tipo de cada elemento del array. Si no es de tipo Casas, se que va a ser de tipo Edificios.
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
                System.out.println("**************");
            }

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("El archivo no existe.");
        }
    }


    //TODO No esta finalizado
    /**
     * Obtener los precios de cada construccion.
     */
    public static void obtenerPrecioConstrucciones() throws IOException, ClassNotFoundException {
        File carpeta = new File(System.getProperty("user.dir"));
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                    System.out.println(". " + archivo.getName().replace(".txt", ""));

                    FileInputStream fileInputStream = new FileInputStream(archivo);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    List<Object> list = (List<Object>) objectInputStream.readObject();
                    HashMap<String, Double> precioList = new HashMap<>();

                    for (Object o : list) {
                        if (o instanceof Casas) {
                            precioList.put(((Casas) o).getDireccion(), ((Casas) o).getPrecioPorM2());
                        } else {
                            precioList.put(((Edificios) o).getDireccion(), ((Edificios) o).getPrecioPorM2());
                        }
                    }
                    System.out.println(precioList);
                }
            }
        }


    }


    /**
     * Crear un archivo. Recibe como parametro la lista de las casas y edificios construidos.
     *
     * @param construccion
     */
    public static void crearFile(List<Object> construccion) throws IOException {

        //Valido que la lista no este vacia. En caso de que este vacia, Tira un sysout con el mensaje de que no hay info cargada.
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
            System.out.println("No hay informacion creada. El archivo no ha sido creado.");
        }
    }
}
