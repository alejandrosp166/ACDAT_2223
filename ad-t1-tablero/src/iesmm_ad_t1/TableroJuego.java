package iesmm_ad_t1;

import java.io.*;
import java.util.Properties;

public class TableroJuego {
    private int nfilas;
    private int ncolumnas;
    private Ficha[][] tablero;

    public TableroJuego(int nfilas, int ncolumnas) {
        this.nfilas = nfilas;
        this.ncolumnas = ncolumnas;
        this.tablero = new Ficha[this.nfilas][this.ncolumnas];
    }

    public TableroJuego(File f) throws IOException, NegativeArraySizeException  {
        // Leemos el fichero de propiedades
        Properties prop = new Properties();
        InputStream input = new FileInputStream(f);
        prop.load(input);
        input.close();

        // Creamos el objeto de tipo tablero
        this.nfilas = Integer.parseInt(prop.getProperty("rows"));
        this.ncolumnas = Integer.parseInt(prop.getProperty("cols"));
        this.tablero = new Ficha[nfilas][ncolumnas];

        // Rellenamos el tablero de manera aleatoria
        rellenarTablero(prop.getProperty("value1").charAt(0), prop.getProperty("value2").charAt(0));
    }

    public void rellenarTablero(char c1, char c2){
        // Recorremos el tablero y le introducimos los caracteres de manera aleatoria
        for (int i = 0; i < tablero.length;i++){
            for (int j = 0; j < tablero[i].length; j++){

                if(Math.round((Math.random() * 1)) == 0){
                    tablero[i][j] = new Ficha(c1);
                } else {
                    tablero[i][j] = new Ficha(c2);
                }
            }
        }
    }

    @Override
    public String toString() {
        // Usamos este bucle para crear la parte superior e inferior del tablero (+---+)
        String supInf = "+ ";
        for (int j =0;j < tablero.length; j++){
            supInf += "- ";
        }
        supInf += "+";

        // Creamos el tablero para mostrarlo por pantalla
        String tableroFormado = supInf +"\n";

        for (int i = 0; i < tablero.length;i++){
            tableroFormado += "| ";
            for (int j = 0; j < tablero[i].length; j++){
                tableroFormado += tablero[i][j].getValor() + " ";
            }
            tableroFormado += "|\n";
        }
        return tableroFormado + supInf;
    }
}