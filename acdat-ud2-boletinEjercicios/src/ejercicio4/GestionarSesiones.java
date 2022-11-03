package ejercicio4;

import java.io.File;

public class GestionarSesiones {
    public static void main(String args[]) {
        GestionarSAXSesiones MyParser = new GestionarSAXSesiones();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "usuarios.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}
