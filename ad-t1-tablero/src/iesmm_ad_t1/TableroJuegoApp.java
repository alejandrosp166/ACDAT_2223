package iesmm_ad_t1;
/*
    Desarrollar TableroJuegoApp, implementando los métodos de la clase TableroJuego y Ficha para que permita:
    * leer la información de un fichero properties compuesto de:
      - las dimensiones (filas x columnas) de un tablero de juego
      - valores de las casillas a procesar
    * representar en cada ficha un valor posible aleatorio.

    Recuerda incluir el tratamiento de errores y posibles excepciones.
    Ejemplo:

    =================
    res/tablero.props
    =================

    # Dimensiones tablero
    rows=3
    cols=4

    # Fichas
    value1=🔴
    value2=❌

    Representación generada:
    +-----------------+
    |  ❌  🔴  🔴  ❌  |
    |  🔴  ❌  🔴  🔴  |
    |  ❌  🔴  ❌  ❌  |
    +-----------------+
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TableroJuegoApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // Creamos el fichero que apuntará a la ruta del fichero de las propiedades
        File f = new File("res" + File.separator + "tablero.props");

        // Se comprueba si el fichero existe, si no existe se le pide al usuario las filas y las columnas del tablero
        if (!f.exists()){
            try{
                System.out.println("El fichero no existe en la ruta especificada\nDame las filas que tendrá el tablero: ");
                int rows  = sc.nextInt();

                System.out.println("Ahora dame las columnas que tendrá el tablero: ");
                int cols = sc.nextInt();

                TableroJuego juego = new TableroJuego(rows, cols);
                System.out.println(juego.toString());
            } catch (InputMismatchException e){
                // Control de excepción por si el usuario no introduce un número entero
                System.err.println("El valor introducido debe ser un número entero");
                //e.printStackTrace();
            }
        } else {
            // Creamos el fichero tablero y lo mostramos por pantalla
            TableroJuego juego = new TableroJuego(f);
            System.out.println(juego.toString());
        }
    }
}
