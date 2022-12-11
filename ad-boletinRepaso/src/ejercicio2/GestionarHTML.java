package ejercicio2;

import java.io.File;

public class GestionarHTML {
    public static void main(String args[]) {
        GestionarSAX MyParser = new GestionarSAX();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "mihtml.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}
