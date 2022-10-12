package proyecto2;

import java.io.File;
import java.util.Scanner;

public class ClientesApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Escribe el fichero que quieres mostrar, solo dos opciones (clientes1.csv // clientes2.csv)");
        String fileName = sc.nextLine();
        File f = new File("res" + File.separator + fileName);

        if (GestionaClientes.generarFichero(f.getAbsolutePath())){
            System.out.println("El fichero se ha generado con éxito, ¿Quieres mostrarlo? (y/n)");
            if (sc.nextLine().equals("y")){
                GestionaClientes.mostrarFichero(new File("res" + File.separator + fileName));
            }

        } else {
            System.err.println("Error al generar el fichero");
        }
    }
}
