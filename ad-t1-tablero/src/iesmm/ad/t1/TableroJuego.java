package iesmm.ad.t1;

import java.io.File;

public class TableroJuego {
	private int nfilas;
	private int ncolumnas;
	private Ficha [][] tablero;
	
	public TableroJuego(int nfilas, int ncolumnas) {
		this.nfilas = nfilas;
		this.ncolumnas = ncolumnas;
	}
	
	public TableroJuego(File f) {

	}
	
	@Override
	public String toString() {
		return "";
	}
}