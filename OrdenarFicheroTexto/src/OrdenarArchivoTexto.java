import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrdenarArchivoTexto {
    static ArrayList<String> contFichero = new ArrayList<>();
    public static File sort(File f){
        if (f.exists()){
            try {
                BufferedReader leer = new BufferedReader (new FileReader(f));
                String txt = leer.readLine();

                while (txt != null){
                    contFichero.add(txt.replaceAll(" ", ""));
                    txt = leer.readLine();
                }

                Collections.sort(contFichero);

                for (String p: contFichero){
                    System.out.println(p);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("El fichero no se encuentra en la ruta especificada.");
        }
        return new File("res" + File.separator + f.getAbsolutePath().replaceAll(".txt", ".tmp"));
    }
}