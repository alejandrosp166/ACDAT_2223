package proyecto1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrdenarArchivoTexto {
    // Declaramos el ArrayList que guardará las líneas del fichero
    static ArrayList<String> contFichero = new ArrayList<>();

    public static File sort(File f) {
        // Declaramos el fichero que guardará el contenido ordenado
        File fOrdenado = null;
        // Comprobamos si el fichero existe o no
        if (f.exists()) {
            try {
                // Creamos el flujo para leer las líneas del fichero
                BufferedReader leer = new BufferedReader(new FileReader(f));
                // Guardamos la primera línea del fichero en un varibale String
                String txt = leer.readLine();
                // Iniciamos un bucle para recorrer las líneas del fichero, si no hay más líneas txt == null
                while (txt != null) {
                    // Guardamos en el ArrayList las líneas sin espacios
                    contFichero.add(txt.replaceAll(" ", ""));
                    // Leemos la siguiente línea
                    txt = leer.readLine();
                }
                // Cerramos el flujo de lectura del fichero
                leer.close();
                // Ordenamos las líneas
                Collections.sort(contFichero);
                // Instanciamos el fichero que guardará el contenido ordenado
                fOrdenado = new File(f.getAbsolutePath().replaceAll(".txt", ".tmp"));
                // Comprobamos si el fichero existe
                if (!fOrdenado.exists()) {
                    // Si el fichero no existe lo creamos
                    fOrdenado.createNewFile();
                }
                // Creamos el flujo de escritura
                FileWriter escribir = new FileWriter(fOrdenado);
                // Escribimos el contenido del array sobre el fichero
                for (String l : contFichero) {
                    escribir.write(l + "\n");
                }
                // Cerramos el flujo de escritura
                escribir.close();

            } catch (IOException e) {
                // Controlamos la excepción por si el flujo con el fichero no se puede realizar
                System.err.println("Error al crear el flujo con el fichero");
                // e.printStackTrace();
            }
        } else {
            // Si el fichero no existe mostramos un mensaje de error
            System.err.println("El fichero no se encuentra en la ruta especificada.");
        }
        // Devolvemos el fichero ordenado
        return fOrdenado;
    }
}
