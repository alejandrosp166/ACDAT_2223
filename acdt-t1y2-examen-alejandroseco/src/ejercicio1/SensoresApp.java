package ejercicio1;

import java.io.File;

public class SensoresApp {
    public static void main(String[] args) {
        GestionarSensores gest = new GestionarSensores();
        if(gest.generar("res" + File.separator + "sensordata.csv")) {
            File f = new File("res" + File.separator + "sensordata.dat");
            gest.ordenar(f);
            gest.toJSON(f);
        }
    }
}
