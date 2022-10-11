package proyecto2;

import java.io.*;
import java.util.ArrayList;

public class GestionaClientes {
    public boolean generarFichero(String fcsv) {
        // COMPROBAR SI EXISTE EL FICHERO TAMBIÉN (CONTROL DE ERRORES)
        if (fcsv.matches("NO TIENE .CSV")) {
            System.err.println("El fichero debe tener la extensión .csv");
            return false;
        }

        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(new File(fcsv)));
            String lineaCli = leer.readLine();

            while (lineaCli != null) {
                String[] sep = lineaCli.split(",");
                clientes.add(new Cliente(sep[0] + " " + sep[1] + " " + sep[2], Long.parseLong(sep[3])));
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

    public void mostrarFichero(File f) {
        if(f.exists()){
            System.out.println("Ruta del archivo: " + f.getAbsolutePath());
            // Deserializar, meter en un array
            ArrayList<Cliente> clientes = new ArrayList<>();

            for (Cliente c : clientes){
                String[] nombreSep = c.getNombre().split(" ");
                System.out.println(c.getTelefono() + nombreSep[0] + "   " + nombreSep[1] + "," + nombreSep[3]);
            }

        } else {
            System.err.println("El fichero no existe");
        }
    }

    public boolean ordenarPorNombre(File f) {
        return true;
    }

    public void duplicados(File f1, File f2, String path) {

    }

}
