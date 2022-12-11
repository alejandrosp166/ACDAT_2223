package ejercicio1;

import java.io.*;

public class GestionCarperta {
    public static void makeGlobalFile(String f) {
        // Creamos el flujo que apunta al directorio
        File dir = new File(f);
        // Comprobamos si el directorio existe
        if (dir.exists()) {
            // Comprobamos si el archivo es un directorio
            if (dir.isDirectory()) {
                // Guardamos en este array la lista de los archivos que componen el directorio
                File[] listDir = dir.listFiles();
                // Recorremos la lista
                for (int i = 0; i < listDir.length; i++) {
                    // Guardamos el nombre del fichero
                    String nombreFichero = listDir[i].getName();
                    // Si la lista acaba en .xml y es un archivo
                    if (nombreFichero.endsWith(".xml")) {
                        try {
                            // Abrimos el flujo con el fichero de escritura apuntando a la ruta del directorio/nombredeldirectorio.txt
                            File archivoEscribir = new File(f + File.separator + dir.getName() + ".txt");
                            // Si no existe el fichero de escritura
                            if (!archivoEscribir.exists()) {
                                // Creamos el fichero
                                archivoEscribir.createNewFile();
                            }
                            // Creamos el flujo de lectura del fichero
                            BufferedReader leer = new BufferedReader(new FileReader(listDir[i]));
                            // Creamos el flujo de escritura del fichero
                            FileWriter escribir = new FileWriter(archivoEscribir, true);
                            // Creamos la variable que contará el número de líneas del fichero
                            int contLineas = 0;
                            // Recorremos el fichero
                            while (leer.readLine() != null) {
                                // Contamos las líneas que lo componen
                                contLineas++;
                            }
                            // Escribimos la línea con los datos del fichero .xml
                            escribir.write(nombreFichero + " Este archivo tiene: " + contLineas + " líneas\n");
                            // Cerramos el flujo de escritura
                            escribir.close();
                            // Cerramos el flujo de lectura
                            leer.close();
                        } catch (IOException e) {
                            // Excepción de E/S
                            System.err.println("Error de E/S inesperado");
                        } catch (Exception e) {
                            // Excepción general
                            System.err.println("Error general");
                        }
                    }
                }
            } else {
                // Avisamos al usuario de que la lista no existe
                System.err.println("La ruta especificada no es un directorio");
            }
        } else {
            // Avisamos al usuario de que la lista no existe
            System.err.println("La ruta especificada no existe");
        }
    }
}
