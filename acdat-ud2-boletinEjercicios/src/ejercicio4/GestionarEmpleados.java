package ejercicio4;

import java.io.File;

public class GestionarEmpleados {
    public static void main(String args[]) {
        GestionarSAXEmpleados MyParser = new GestionarSAXEmpleados();

        if (MyParser.abrir_XML_SAX(new File("res" + File.separator + "empleados.xml")) == 0) {
            // Si el documento se ha parseado correctamente
            // Mostrar lo procesado por el parser
            MyParser.imprimirNodos();
        }
    }
}
