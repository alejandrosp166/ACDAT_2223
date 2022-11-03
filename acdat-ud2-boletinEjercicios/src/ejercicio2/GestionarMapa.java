package ejercicio2;

import java.io.File;

public class GestionarMapa {
    public static void main(String args[]) {
        GestionarSAXMapa MyParser = new GestionarSAXMapa();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "mapa.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}
