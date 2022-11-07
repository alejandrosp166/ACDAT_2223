package ejercicio5;

import java.io.File;

public class GestionarVuelo {
    public static void main(String args[]) {
        GestionarSAXVuelo MyParser = new GestionarSAXVuelo();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "vuelos.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}
