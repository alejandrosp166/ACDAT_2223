import java.io.File;
import java.util.Scanner;

public class ListaFicherosExtension {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce la ruta de un directorio: ");
        String path = sc.nextLine();

        File f = new File(path);
        if(f.isDirectory()){
            System.out.println("El archivo es un directorio");

            for(String arch : f.list()){
                if (arch.matches("[a-zA-Z]+.txt")){ // https://regexr.com/ (página utilizada para probar los patterns)
                    System.out.println(arch);
                }
            }
        } else if (f.isFile()){
            System.out.println("El archivo no es un directorio, es un fichero");
        } else {
            System.out.println("No existe la ruta");
        }
    }
}
