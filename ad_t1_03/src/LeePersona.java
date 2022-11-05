import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeePersona {
    public static void main(String[] args) {
        File f = new File("res" + File.separator + "personas.dat");

        if (f.exists()){
            try {
                DataInputStream finput = new DataInputStream(new FileInputStream(f));
                System.out.println("Nombre cliente: " + finput.readUTF());
                System.out.println("Edad cliente: " + finput.readInt());

            } catch (IOException e){
                System.err.println("Error al leer el fichero");
            }
        } else {
            System.err.println("El fichero no existe");
        }
    }
}
