package ejercicio6;

import java.io.File;

public class GestionarCatalogo {
    public static void main(String args[]) {
        GestionarSAXCatalogo MyParser = new GestionarSAXCatalogo();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "catalogo.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}
