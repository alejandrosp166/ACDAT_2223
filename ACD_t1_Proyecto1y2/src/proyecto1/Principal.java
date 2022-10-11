package proyecto1;

import proyecto1.OrdenarArchivoTexto;

import java.io.*;

public class Principal {
    public static void main(String[] args) {
        File f = OrdenarArchivoTexto.sort(new File("res" + File.separator + "fichero.txt"));
    }
}
