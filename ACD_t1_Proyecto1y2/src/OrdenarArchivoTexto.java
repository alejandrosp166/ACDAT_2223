import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrdenarArchivoTexto {
    static ArrayList<String> contFichero = new ArrayList<>();
    public static File sort(File f){
        File fOrdenado = null;

        if (f.exists()){
            try {
                BufferedReader leer = new BufferedReader (new FileReader(f));
                String txt = leer.readLine();

                while (txt != null){
                    contFichero.add(txt.replaceAll(" ", ""));
                    txt = leer.readLine();
                }

                leer.close();
                Collections.sort(contFichero);

                fOrdenado = new File(f.getAbsolutePath().replaceAll(".txt", ".tmp"));

                if(!fOrdenado.exists()){
                    fOrdenado.createNewFile();
                }

                FileWriter escribir = new FileWriter(fOrdenado);

                for (String l:contFichero){
                    escribir.write(l + "\n");
                }

                escribir.close();
                
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("El fichero no se encuentra en la ruta especificada.");
        }
        return fOrdenado;
    }
}
