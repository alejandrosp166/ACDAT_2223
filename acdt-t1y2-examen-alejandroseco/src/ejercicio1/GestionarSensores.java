package ejercicio1;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionarSensores {
    public boolean generar(String fcsv) {
        File f = new File(fcsv);

        if (f.exists()) {
            if (f.isFile()) {
                if (f.getName().endsWith("csv")) {
                    try {
                        BufferedReader leer = new BufferedReader(new FileReader(f));
                        String linea = leer.readLine();
                        List<Sensor> listSensor = new ArrayList<>();

                        while (linea != null) {
                            String[] temp = linea.split(":");
                            String[] latLong = temp[1].split(",");

                            if (Integer.parseInt(temp[0]) < 0) {
                                listSensor.add(new Sensor(Integer.parseInt(temp[0]), Float.parseFloat(latLong[0]), Float.parseFloat(latLong[1])));
                            }
                            linea = leer.readLine();
                        }
                        leer.close();

                        if (listSensor.size() > 0) {
                            File fSalida = new File(fcsv.replace(".csv", ".dat"));
                            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(fSalida));
                            escribir.writeObject(listSensor);
                            escribir.close();
                            return true;
                        } else {
                            System.err.println("El fichero está vacío!");
                        }
                    } catch (IOException e) {
                        System.err.println("Error E/S");
                    } catch (Exception e) {
                        System.err.println("Error general");
                    }
                } else {
                    System.err.println("El fichero no utiliza el formato .csv");
                }
            } else {
                System.err.println("El archivo no es un fichero");
            }
        } else {
            System.err.println("El fichero no existe");
        }
        return false;
    }

    public boolean ordenar(File f) {
        if (f.exists()) {
            try {
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream(f));
                List<Sensor> listSensor = (List<Sensor>) leer.readObject();

                if (listSensor.size() > 0) {
                    ordenarPorTemperatura(listSensor);
                    File fSalida = new File(f.getAbsolutePath().replace("sensordata.dat", "ordenado.txt"));
                    FileWriter escribir = new FileWriter(fSalida);

                    escribir.write("El número total de medidas recogidas es: " + listSensor.size() + "\n");

                    for (Sensor s : listSensor) {
                        escribir.write(s.toString() + "\n");
                    }

                    escribir.close();
                    return true;
                } else {
                    System.err.println("El fichero no contiene datos!");
                }
            } catch (IOException e) {
                System.err.println("Error E/S");
            } catch (ClassNotFoundException e) {
                System.err.println("El fichero no contiene datos correctos!");
            }
        } else {
            System.err.println("El fichero no existe");
        }
        return false;
    }

    public void toJSON(File f) {
        if (f.exists()) {
            try {
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream(f));
                List<Sensor> listSensor = (List<Sensor>) leer.readObject();
                if (listSensor.size() > 0) {
                    ordenarPorTemperaturaCreciente(listSensor);
                    Gson transformer = new Gson();
                    String json = transformer.toJson(listSensor);
                    System.out.println("El número de variables recogidas es: " + listSensor.size());
                    System.out.println(json);
                }
            } catch (IOException e) {
                System.err.println("Error E/S");
            } catch (ClassNotFoundException e) {
                System.err.println("El fichero no contiene datos correctos!");
            }
        } else {
            System.err.println("El fichero no existe");
        }
    }

    private void ordenarPorTemperaturaCreciente(List<Sensor> listSensor) {
        Sensor aux;
        for (int i = 0; i < listSensor.size() - 1; i++) {
            for (int j = 0; j < listSensor.size() - i - 1; j++) {
                if (listSensor.get(j + 1).getTemperatura() > listSensor.get(j).getTemperatura()) {
                    aux = listSensor.get(j + 1);
                    listSensor.set(j + 1, listSensor.get(j));
                    listSensor.set(j, aux);
                }
            }
        }
    }

    private void ordenarPorTemperatura(List<Sensor> listSensor) {
        Sensor aux;
        for (int i = 0; i < listSensor.size() - 1; i++) {
            for (int j = 0; j < listSensor.size() - i - 1; j++) {
                if (listSensor.get(j + 1).getTemperatura() < listSensor.get(j).getTemperatura()) {
                    aux = listSensor.get(j + 1);
                    listSensor.set(j + 1, listSensor.get(j));
                    listSensor.set(j, aux);
                }
            }
        }
    }
}
