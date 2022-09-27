package iesmm_ad_t1;

import java.io.*;
import java.util.Properties;

public class TableroJuego {
    private int nfilas;
    private int ncolumnas;
    private Ficha[][] tablero;

    public TableroJuego(int nfilas, int ncolumnas) {
        tablero = new Ficha[nfilas][ncolumnas];
    }

    public TableroJuego(File f) {

        Properties propiedades = new Properties();
        try {
            InputStream entrada = new FileInputStream(f);
            propiedades.load(entrada);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tablero = new Ficha[Integer.parseInt(propiedades.getProperty("rows"))][Integer.parseInt(propiedades.getProperty("cols"))];
        rellenarTablero(propiedades);
    }

    public void rellenarTablero(Properties propiedades){

        for (int i = 0; i < tablero.length;i++){
            for (int j = 0; j < tablero[i].length; j++){
                if(Math.random() * 1 == 1){
                    tablero[i][j] = new Ficha(propiedades.getProperty("value1").charAt(0));
                } else{
                    tablero[i][j] = new Ficha(propiedades.getProperty("value2").charAt(0));
                }
            }
        }
    }

    @Override
    public String toString() {

        for(Ficha[] f: tablero){
            System.out.println(f.toString());
        }

        return null;
    }
}