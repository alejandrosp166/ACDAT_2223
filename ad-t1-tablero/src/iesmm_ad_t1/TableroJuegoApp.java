package iesmm.ad.t1;
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

public class TableroJuegoApp {
    public static void main(String[] args) {

        Properties propiedades = new Properties();

        try {
            InputStream entrada = new FileInputStream("D:\\ProyectosIntelliJ\\ACDAT_2223\\ad-t1-tablero\\res\\tablero.props");
            propiedades.load(entrada);
        } catch (FileNotFoundException e){

        } catch (IOException e){

        }
        aishdaksdhasd;
    }
}
