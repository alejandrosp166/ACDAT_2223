package proyecto2;

import java.io.*;
import java.util.ArrayList;

public class GestionaClientes {
    public static boolean generarFichero(String fcsv) {
        if (!fcsv.endsWith(".csv") || !new File(fcsv).exists()) {
            // Controlar que el fichero que se va a serializar sea con la extensión .csv
            System.err.println("El fichero no existe o no tiene la extensión .csv");
            return false;
        }
        // Declaramos el array que guardará los datos de los clientes
        ArrayList<Cliente> clients = new ArrayList<>();

        try {
            // Creamos el flujo de lectura del fichero
            BufferedReader leer = new BufferedReader(new FileReader(new File(fcsv)));
            // Leemos la primera línea
            String lineaCli = leer.readLine();

            // Leemos la líneas hasta que se termine el fichero
            while (lineaCli != null) {
                // Guardamos los datos de manera separa en un array con la función split
                String[] sep = lineaCli.split(",");
                // Creamos el cliente y lo guardamos en el array
                clients.add(new Cliente(sep[0] + " " + sep[1] + " " + sep[2], Long.parseLong(sep[3])));
                // Leemos la siguiente línea
                lineaCli = leer.readLine();
            }
            // Cerramos el flujo de lectura
            leer.close();
            // Generamos el mismo fichero en la ruta que nos han pasado por parámetro pero esta vez con la extensión .dat
            ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(fcsv.replaceFirst(".csv", ".dat")));
            // Y le escribimos los datos serializados
            ser.writeObject(clients);
            // Cerramos el flujo de escritura
            ser.close();

        } catch (IOException e) {
            // Controlar excepción en caso de que el fichero no se pueda leer
            System.err.println("Error a la hora de leer el fichero");
            //e.printStackTrace();
        }
        return true;
    }
    public static void mostrarFichero(File f) {
        // Comprobamos que el fichero exista y que termine en la extensión .dat
        if(f.exists() && f.getAbsolutePath().endsWith(".dat")){
            // Mostramos la ruta del archivo
            System.out.println("Ruta del archivo: " + f.getAbsolutePath());
            try {
                // Creamos el flujo de lectura
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream(f));
                // Creamos el array donde guardaremos los datos
                ArrayList<Cliente> clients = (ArrayList<Cliente>) leer.readObject();

                for (Cliente c : clients){
                    // Separamos el nombre para poder poner la coma en el segundo espacio
                    String[] nameSep = c.getNombre().split(" ");
                    // Mostramos los datos y pasamos los nombres a mayúsculas
                    System.out.println(c.getTelefono() + "   " + (nameSep[0] + " " + nameSep[1] + ", " + nameSep[2]).toUpperCase());
                }
            } catch (IOException e) {
                // Controlar excepción en caso de que el fichero no se pueda leer
                System.err.println("Error a la hora de leer el fichero");
                //e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // Controlar la excepción
                System.err.println("");
                //e.printStackTrace();
            }
        } else {
            System.err.println("El fichero no existe o no tiene la extensión .dat");
        }
    }

    public static boolean ordenarPorNombre(File f) {
        if (!f.exists() && !f.getAbsolutePath().endsWith(".dat")){
            // Controlar que el fichero que se va a ordenar termine en .dat
            System.err.println("El fichero no existe o no tiene la extensión .dat");
            return false;
        }
        return true;
    }

    public static void duplicados(File f1, File f2, String path) {

    }

}
