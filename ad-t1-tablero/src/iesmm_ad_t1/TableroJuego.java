package iesmm.ad.t1;

import java.io.File;

public class TableroJuego {
    private int nfilas;
    private int ncolumnas;
    private Ficha[][] tablero;

    public TableroJuego(int nfilas, int ncolumnas) {
        tablero = new Ficha[nfilas][ncolumnas];
    }

    public TableroJuego(File f) {

    }

    @Override
    public String toString() {
        String tableroCadena = "";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tableroCadena += tablero[i][j];
            }
            tableroCadena += "\n";
        }
        return tableroCadena;
    }
}