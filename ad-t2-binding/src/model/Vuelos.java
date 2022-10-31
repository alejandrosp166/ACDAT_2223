package model;

import java.util.ArrayList;
import java.util.List;

public class Vuelos {
    // Contenedor de objetos vuelo
    private List<Vuelo> vuelos;

    public Vuelos() {
        this.vuelos = new ArrayList<Vuelo>();
    }

    public void add(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
