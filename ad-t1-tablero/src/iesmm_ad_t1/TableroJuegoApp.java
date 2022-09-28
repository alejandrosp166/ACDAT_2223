package iesmm_ad_t1;
/*
    Desarrollar TableroJuegoApp, implementando los métodos de la clase TableroJuego y Ficha para que permita:
    * leer la información de un fichero properties compuesto de:
      - las dimensiones (filas x columnas) de un tablero de juego
      - valores de las casillas a procesar

    * representar en cada ficha un valor posible aleatorio.

    Recuerda incluir el tratamiento de errores y posibles excepciones.
    EJEMPLO -> Valores negativos en el array
    CREAR EL FICHERO CUANDO NO EXISTE Y RELLENARLO

    Representación generada:
    +-----------------+
    |  ❌  🔴  🔴  ❌  |
    |  🔴  ❌  🔴  🔴  |
    |  ❌  🔴  ❌  ❌  |
    +-----------------+

 */

import java.io.*;
import java.util.Properties;

public class TableroJuegoApp {
    public static void main(String[] args) {
        File f = new File("res/tablero.props");

        if (f.exists()){
            TableroJuego tablero = new TableroJuego(f);
            System.out.println(tablero.toString());
        } else {
            System.out.println("El fichero no existe en la ruta especificada");
        }
    }
}
