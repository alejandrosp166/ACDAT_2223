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

public class TableroJuegoApp {

    //static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        File f = new File("res/tablero.props");

        if (!f.exists()){
            System.out.println("El fichero no existe en la ruta especificada, se creará uno nuevo con valores por defecto...");
            crearFicheroPropiedadesPorDefecto(f);
        }

        TableroJuego juego = new TableroJuego(f);
        System.out.println(juego.toString());
    }

    private static void crearFicheroPropiedadesPorDefecto(File f){
        try {
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("#Dimensiones del tablero\nrows=3\ncols=4\n#Fichas\nvalue1=\uD83D\uDD34\nvalue2=❌");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
