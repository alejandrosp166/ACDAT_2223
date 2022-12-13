package ejercicio1;

import java.io.Serializable;

public class Sensor implements Serializable {
    private int temperatura;
    private float latitud, longitud;

    public Sensor(int temperatura, float latitud, float longitud) {
        this.temperatura = temperatura;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "temperatura=" + temperatura +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
