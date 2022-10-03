package iesmm_ad_t1;
/*
    Desarrollar TableroJuegoApp, implementando los métodos de la clase TableroJuego y Ficha para que permita:
    * leer la información de un fichero properties compuesto de:
      - las dimensiones (filas x columnas) de un tablero de juego
      - valores de las casillas a procesar

    * representar en cada ficha un valor posible aleatorio.

    Recuerda incluir el tratamiento de errores y posibles excepciones.
    EJEMPLO -> Valores negativos en el array

    Representación generada:
    +-----------------+
    |  ❌  🔴  🔴  ❌  |
    |  🔴  ❌  🔴  🔴  |
    |  ❌  🔴  ❌  ❌  |
    +-----------------+

 */

import java.io.*;
import java.util.Scanner;

public class TableroJuegoApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // Creamos el fichero que apuntará a la ruta del fichero de las propiedades
        File f = new File("res" + File.separator + "tablero.props");

        // Se comprueba si el fichero existe, si no existe se le pide al usuario valores
        if (!f.exists()){
            System.out.println("El fichero no existe en la ruta especificada\nDame las filas que tendrá el tablero: ");
            int rows = sc.nextInt();
            System.out.println("Ahora dame las columnas que tendrá el fichero: ");
            int cols = sc.nextInt();

            TableroJuego juego = new TableroJuego(rows, cols);
            System.out.println(juego.toString());
        } else {
            // Creamos el fichero tablero y lo mostramos por pantalla
            try {
                TableroJuego juego = new TableroJuego(f);
                System.out.println(juego.toString());
            } catch (IOException e){
                // Control de excepción por si no podemos leer el fichero
                System.err.println("Error al leer el fichero");
                //e.printStackTrace();
            } catch (NegativeArraySizeException e){
                // Control de excepción por si intentamos crear un array con valores negativos
                System.err.println("Las filas o las columnas del tablero no pueden ser un valor negativo");
                //e.printStackTrace();
            }
        }
    }
}
