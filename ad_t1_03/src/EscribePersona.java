import java.io.*;
import java.util.Scanner;

public class EscribePersona {
    public static void main(String[] args) {
        File f = new File("res" + File.separator + "personas.dat");
        Scanner sc = new Scanner(System.in);

        if(!f.exists()){
            try {
                //CREAR FLUJO BINARIO
                DataOutputStream fout = new DataOutputStream(new FileOutputStream(f));

                //SOLICITAR DATOS AL USUARIO
                System.out.println("Introduce nombre del cliente");
                String nombre = sc.nextLine();

                System.out.println("Dame la edad del cliente");
                int edad = sc.nextInt();

                //ESCRIBIR DATOS EN EL FICHERO
                fout.writeUTF(nombre);
                fout.writeInt(edad);

                //CERRAR FICHERO
                fout.close();
            } catch (IOException e){
                System.err.println("Error en la escritura del fichero");
            }
        } else {
            System.err.println("El fichero no se puede sobreescribir");
        }
    }
}
