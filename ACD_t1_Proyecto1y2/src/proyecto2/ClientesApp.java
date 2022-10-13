package proyecto2;

import java.io.File;
import java.util.Scanner;

public class ClientesApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Vamos a serializar los ficheros clientes1.csv y clientes2.csv en los ficheros clientes1.dat y clientes2.dat (APARTADO 1)");
        File f1 = new File("res" + File.separator + "clientes1.csv");
        File f2 = new File("res" + File.separator + "clientes2.csv");

        if (f1.exists() && f2.exists()){
            if (GestionaClientes.generarFichero(f1.getAbsolutePath()) && GestionaClientes.generarFichero(f2.getAbsolutePath())){
                System.out.println("Los ficheros se han serializado con éxito, ¿Quieres mostrarlos? (y/n) PD: No están ordenados por nombre (APARTADO 2)");

                if (sc.nextLine().equals("y")){
                    GestionaClientes.mostrarFichero(new File(f1.getAbsolutePath().replaceFirst(".csv",".dat")));
                    System.out.println("\n--------------------------------------------\n");
                    GestionaClientes.mostrarFichero(new File(f2.getAbsolutePath().replaceFirst(".csv",".dat")));
                }

                if (GestionaClientes.ordenarPorNombre(new File(f1.getAbsolutePath().replaceFirst(".csv",".dat"))) && GestionaClientes.ordenarPorNombre(new File(f2.getAbsolutePath().replaceFirst(".csv",".dat")))){
                    System.out.println("Se han generado dos ficheros .tmp serializados ordenados por nombre (APARTADO 3)");
                }

                System.out.println("Ahora vamos a ordenar los ficheros cliente1.csv y clientes2.csv en un solo fichero .dat, dame la ruta donde quieres generar el fichero (Debe ser absoluta): (APARTADO 4)");
                GestionaClientes.duplicados(new File("res" + File.separator +"clientes1.dat"), new File("res" + File.separator + "clientes2.dat"), sc.nextLine());
            } else {
                System.err.println("Error al generar los ficheros");
            }
        } else {
            System.err.println("Alguno de los ficheros no existen");
        }
    }
}