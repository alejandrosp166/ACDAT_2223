package proyecto2;

import java.io.*;
import java.util.ArrayList;

public class GestionaClientes {
    public boolean generarFichero(String fcsv){
        // COMPROBAR SI EXISTE EL FICHERO TAMBIÉN (CONTROL DE ERRORES)
        // LÍNEA 21 SEPARAR LA CADENA Y ALMACENAR LOS DATOS EN EL ARRAY
        if (fcsv.matches("NO TIENE .CSV")){
            System.err.println("El fichero debe tener la extensión .csv");
            return false;
        }

        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(new File(fcsv)));
            String lineaCli = leer.readLine();

            while (lineaCli != null) {
                clientes.add(new Cliente("pepe",234));
                lineaCli = leer.readLine();
            }
            leer.close();

            ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(fcsv.replaceFirst(".csv", ".dat")));
            ser.writeObject(clientes);
            ser.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return true;
    }

    public void mostrarFichero(File f){

    }

    public boolean ordenarPorNombre(File f){
        return true;
    }

    public void duplicados(File f1, File f2, String path){

    }

}
