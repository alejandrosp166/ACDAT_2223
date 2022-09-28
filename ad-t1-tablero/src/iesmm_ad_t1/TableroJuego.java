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
        tablero = new Ficha[this.nfilas][this.ncolumnas];
    }

    public TableroJuego(File f) {
        Properties propiedades = new Properties();
        try {
            InputStream entrada = new FileInputStream(f);
            propiedades.load(entrada);
        } catch (IOException e){
            e.printStackTrace();
        }
        //CONTROLAR EXCEPCIÓN PARA QUE SEA UN NÚMERO EL INTEGER PARSE INT
        tablero = new Ficha[Integer.parseInt(propiedades.getProperty("rows"))][Integer.parseInt(propiedades.getProperty("cols"))];
        rellenarTablero(propiedades);
    }

    @Override
    public String toString() {
        String tableroFormado = "";

        for (int i = 0; i < tablero.length;i++){
            tableroFormado += "| ";
            for (int j = 0; j < tablero[i].length; j++){
                tableroFormado += tablero[i][j].getValor() + " ";
            }
            tableroFormado += "|\n";
        }
        return tableroFormado;
    }

    public void rellenarTablero(Properties prop){

        for (int i = 0; i < tablero.length;i++){
            for (int j = 0; j < tablero[i].length; j++){

                if((int)(Math.random() * 2) == 0){
                    tablero[i][j] = new Ficha(prop.getProperty("value1").charAt(0));
                } else{
                    tablero[i][j] = new Ficha(prop.getProperty("value2").charAt(0));
                }
            }
        }
    }
}