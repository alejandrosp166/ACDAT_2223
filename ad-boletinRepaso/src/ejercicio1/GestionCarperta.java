package ejercicio1;

import java.io.*;

public class GestionCarperta {
    public static File makeGlobalFile(String f) {

        File dir = new File(f);

        if (dir.isDirectory()) {
            String[] listDir = dir.list();
            for (int i = 0; i < listDir.length; i++) {

                if(listDir[i].endsWith(".xml") && new File(dir.getAbsolutePath() + listDir[i]).isFile()) {
                    escribirFichero(listDir[i]);
                }
            }
        }
        return null;
    }

    private static void escribirFichero(String name) {

        try {
            File archivoAEscribir = new File("RUTA DIRECTORIO + \\ + NOMBRE_DIRECTORIO.TXT");
            File archivoALeer = new File("RUTA DIRECTORIO + \\ + NOMBRE_ARCHIVO.XML");
            
            BufferedReader leer = new BufferedReader(new FileReader(archivoAEscribir));
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoALeer));
            
            String linea = leer.readLine();

            while (linea != null) {
                
            }

            leer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int contLineas(String f) {
        return 0;
    }
}
