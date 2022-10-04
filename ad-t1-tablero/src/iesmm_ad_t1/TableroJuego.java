package iesmm_ad_t1;

import java.io.*;
import java.util.Properties;

public class TableroJuego {
    private int nfilas;
    private int ncolumnas;
    private Ficha[][] tablero;

    public TableroJuego(int nfilas, int ncolumnas) {
        try {
            // Creamos el objeto tablero
            this.nfilas = nfilas;
            this.ncolumnas = ncolumnas;
            this.tablero = new Ficha[this.nfilas][this.ncolumnas];
            rellenarTablero("", "", 1);
        } catch (NegativeArraySizeException e) {
            // Control de excepción por si intentamos crear un array con valores negativos
            System.err.println("Las filas o las columnas del tablero no pueden ser un valor negativo");
            //e.printStackTrace();
        }
    }

    public TableroJuego(File f) {
        Properties prop = new Properties();

        try {
            // Leemos el fichero de propiedades
            InputStream input = new FileInputStream(f);
            prop.load(input);
            input.close();

            // Creamos el objeto tablero
            this.nfilas = Integer.parseInt(prop.getProperty("rows"));
            this.ncolumnas = Integer.parseInt(prop.getProperty("cols"));
            this.tablero = new Ficha[nfilas][ncolumnas];

            // Rellenamos el tablero de manera aleatoria
            rellenarTablero(prop.getProperty("value1"), prop.getProperty("value2"), 0);
        } catch (IOException e) {
            // Control de excepción por si no podemos leer el fichero
            System.err.println("Error al leer el fichero");
            //e.printStackTrace();
        } catch (NegativeArraySizeException e) {
            // Control de excepción por si intentamos crear un array con valores negativos
            System.err.println("Las filas o las columnas del tablero no pueden ser un valor negativo, revise el fichero de configuración");
            //e.printStackTrace();
        } catch (NumberFormatException e) {
            // Control de excepción por si el fichero propiedades no almacena un valor númerico en rows o cols
            System.err.println("El valor de rows y cols en el fichero propiedades debe ser un número");
            //e.printStackTrace();
        }
    }

    public void rellenarTablero(String c1, String c2, int opc) {
        // Recorremos el tablero y le introducimos los caracteres de manera aleatoria (los caracteres que se piden solo se usaran en el caso de que opc sea == 0,
        // esto lo hacemos porque hay dos constructores uno que usa un fichero propiedades y otro que no)
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (opc == 0) {
                    if (Math.round((Math.random() * 1)) == 0) {
                        tablero[i][j] = new Ficha(c1);
                    } else {
                        tablero[i][j] = new Ficha(c2);
                    }
                } else {
                    tablero[i][j] = new Ficha(" ");
                }
            }
        }
    }

    @Override
    public String toString() {
        try {
            // Usamos este bucle para crear la parte superior e inferior del tablero (+---+)
            String supInf = "+  ";
            for (int j = 0; j <= tablero.length; j++) {
                supInf += "-  ";
            }
            supInf += "+";

            // Hacemos un bucle bidimensional para pintar el tablero
            String tableroFormado = supInf + "\n";

            for (int i = 0; i < tablero.length; i++) {
                tableroFormado += "| ";
                for (int j = 0; j < tablero[i].length; j++) {
                    tableroFormado += tablero[i][j].getValor() + " ";
                }
                tableroFormado += "|\n";
            }
            return tableroFormado + supInf;
        } catch (NullPointerException e) {
            // Excepción para cuando no se ha podido instanciar el objeto tablero y tablero.length no da un número entero
            System.err.println("No se pudo pintar el tablero");
            return null;
        }
    }
}