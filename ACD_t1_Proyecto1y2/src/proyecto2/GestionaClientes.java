package proyecto2;

import java.io.*;
import java.text.FieldPosition;
import java.util.ArrayList;

public class GestionaClientes {

    // Declaramos el array que guardará los datos de los clientes
    static ArrayList<Cliente> clients = new ArrayList<>();
    public static boolean generarFichero(String fcsv) {
        if (!fcsv.endsWith(".csv") || !new File(fcsv).exists()) {
            // Controlar que el fichero que se va a serializar sea con la extensión .csv y que exista
            System.err.println("El fichero no existe o no tiene la extensión .csv");
            return false;
        }
        // Limpiamos datos por si hubiera dentro del Array
        clients.clear();

        try {
            // Creamos el flujo de lectura del fichero
            BufferedReader leer = new BufferedReader(new FileReader(new File(fcsv)));
            // Leemos la primera línea
            String lineaCli = leer.readLine();

            // Leemos las líneas hasta que se termine el fichero
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
        if (f.exists() && f.getAbsolutePath().endsWith(".dat")) {
            // Mostramos la ruta del archivo
            System.out.println("Ruta del archivo: " + f.getAbsolutePath());
            try {
                // Creamos el flujo de lectura
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream(f));
                // Limpiamos datos por si hubiera dentro del Array y guardamos los datos dentro del array
                clients.clear();
                clients = (ArrayList<Cliente>) leer.readObject();
                // Cerramos el flujo de lectura
                leer.close();

                for (Cliente c : clients) {
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
                // Controlar excepción por si el fichero no se puede almacenar dentro del array
                System.err.println("No se pudo almacenar el fichero de binario dentro del array");
                // e.printStackTrace();
            }
        } else {
            System.err.println("El fichero no existe o no tiene la extensión .dat");
        }
    }

    public static boolean ordenarPorNombre(File f) {
        if (!f.exists() && !f.getAbsolutePath().endsWith(".dat")) {
            // Controlar que el fichero que se va a ordenar termine en .dat y exista
            System.err.println("El fichero no existe o no tiene la extensión .dat");
            return false;
        }

        try {
            // Creamos el flujo de lectura
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream(f));
            // Limpiamos datos por si hubiera dentro del Array y guardamos los datos dentro del array
            clients.clear();
            clients = (ArrayList<Cliente>) leer.readObject();
            // Cerramos el flujo de lectura
            leer.close();
            // Ordenamos el array por el nombre con el método de la burbuja
            metodoBurbujaOrdenarNombre();

            // Generamos el mismo fichero en la misma ruta del fichero pasado por parámetro pero con la extensión .tmp
            ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath() + ".tmp"));
            // Y le escribimos los datos serializados
            ser.writeObject(clients);
            // Cerramos el flujo de escritura
            ser.close();

        } catch (IOException e) {
            // Controlar excepción en caso de que el fichero no se pueda leer
            System.err.println("Error a la hora de leer el fichero");
            return false;
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Controlar excepción por si el fichero no se puede almacenar dentro del array
            System.err.println("No se pudo almacenar el fichero binario dentro del array");
            // e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void duplicados(File f1, File f2, String path) {
        try {
            if (f1.exists() && f2.exists()){
                // Creamos el flujo de lectura
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream(f1));
                // Limpiamos datos por si hubiera dentro del Array y guardamos los datos dentro del array
                clients.clear();
                clients = (ArrayList<Cliente>) leer.readObject();
                // Ahora introducimos los datos del segundo fichero
                leer = new ObjectInputStream(new FileInputStream(f2));
                // Y lo "concatenamos" con los datos que había anteriormente dentro del array, es decir f1 + f2
                clients.addAll((ArrayList<Cliente>) leer.readObject());
                // Cerramos el flujo de lectura
                leer.close();
                // Ordenamos el array por el nombre del cliente
                metodoBurbujaOrdenarNombre();
                // Generamos el mismo fichero en la ruta que nos han pasado por parámetro pero esta vez con la extensión .dat
                ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(new File(path + "\\duplicados.dat.tmp")));
                // Y le escribimos los datos serializados
                ser.writeObject(clients);
                // Cerramos el flujo de escritura
                ser.close();
            } else {
                // Controlar que los ficheros existan en la ruta
                System.err.println("Alguno de los ficheros (clientes1.dat o clientes2.dat) no existen en la carpeta res");
            }
        } catch (IOException e) {
            // Controlar excepción en caso de que el fichero no se pueda leer
            System.err.println("Error a la hora de leer o escribir en el fichero");
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Controlar excepción por si el fichero no se puede almacenar dentro del array
            System.err.println("No se pudo almacenar el fichero binario dentro del array");
            // e.printStackTrace();
        }
    }

    private static void metodoBurbujaOrdenarNombre(){
        Cliente aux;
        for (int i = 0; i < clients.size() - 1; i++) {
            for (int j = 0; j < clients.size() - i - 1; j++) {
                if (clients.get(j + 1).getNombre().compareTo(clients.get(j).getNombre()) < 0) {
                    aux = clients.get(j + 1);
                    clients.set(j + 1, clients.get(j));
                    clients.set(j, aux);
                }
            }
        }
    }
}
