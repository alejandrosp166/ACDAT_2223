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

public class TableroJuegoApp {

    //static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // Creamos el fichero que apuntará a la ruta del fichero de las propiedades
        File f = new File("res" + File.separator + "tablero.props");

        // Se comprueba si el fichero existe, si no existe se crea uno nuevo con valores por defecto
        if (!f.exists()){
            System.out.println("El fichero no existe en la ruta especificada, se creará uno nuevo con valores por defecto...");
            crearFicheroPropiedadesPorDefecto(f);
        }

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

    private static void crearFicheroPropiedadesPorDefecto(File f){
        try {
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("#Dimensiones del tablero\nrows=3\ncols=4\n#Fichas\nvalue1=\uD83D\uDD34\nvalue2=❌");
            fw.close();
        } catch (IOException e) {
            System.err.println("No se pudo crear el fichero de propiedades");
            e.printStackTrace();
        }
    }
}
