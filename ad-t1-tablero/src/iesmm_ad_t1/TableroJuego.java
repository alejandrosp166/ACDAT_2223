package iesmm_ad_t1;

import java.io.*;
import java.util.Properties;

public class TableroJuego {
    private int nfilas;
    private int ncolumnas;
    private Ficha[][] tablero;
    // PREGUNTAR A ALEJANDRO SOBRE ESTE MÉTODO CONSTRUCTOR Y COMO PUEDE SER IMPLEMETENTADO PARA SU USO
    public TableroJuego(int nfilas, int ncolumnas) {
        this.nfilas = nfilas;
        this.ncolumnas = ncolumnas;
        this.tablero = new Ficha[this.nfilas][this.ncolumnas];
    }

    public TableroJuego(File f) {
        Properties prop = new Properties();

        try {
            InputStream entrada = new FileInputStream(f);
            prop.load(entrada);
        } catch (IOException e){
            e.printStackTrace();
        }

        // CONTROLAR EXCEPCIÓN PARA QUE SEA UN NÚMERO EL INTEGER PARSE INT

        this.nfilas = Integer.parseInt(prop.getProperty("rows"));
        this.ncolumnas = Integer.parseInt(prop.getProperty("cols"));
        this.tablero = new Ficha[nfilas][ncolumnas];

        rellenarTablero(prop.getProperty("value1").charAt(0), prop.getProperty("value2").charAt(0));
    }

    public void rellenarTablero(char c1, char c2){

        for (int i = 0; i < tablero.length;i++){
            for (int j = 0; j < tablero[i].length; j++){

                if((int)(Math.random() * 2) == 0){
                    tablero[i][j] = new Ficha(c1);
                } else{
                    tablero[i][j] = new Ficha(c2);
                }
            }
        }
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
}