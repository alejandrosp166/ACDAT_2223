package ejercicio2;

import java.io.File;

public class EmpleadosApp {
    public static void main(String[] args) {
        GestionarSAX MyParser = new GestionarSAX();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "company.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}