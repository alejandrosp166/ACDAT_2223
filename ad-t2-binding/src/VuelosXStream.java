import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import model.Vuelo;
import model.Vuelos;

public class VuelosXStream {

    /**
     * Serialización desde una colección de objetos hacia formato XML
     *
     * @param vuelos Colección de objetos de entrada de tipo Vuelo
     * @return cadena XML de la colección de objetos
     */
    public String serializarXML(Vuelos vuelos) {
        return serializar(vuelos, "xml");
    }

    /**
     * Serialización desde una colección de objetos hacia formato JSON
     *
     * @param vuelos Colección de objetos de entrada de tipo Vuelo
     * @return cadena JSON de la colección de objetos
     */
    public String serializarJSON(Vuelos vuelos) {
        return serializar(vuelos, "json");
    }

    /**
     * Serializador del contenedor dado un formato (XML, JSON)
     *
     * @param vuelos Colección de objetos de entrada de tipo Vuelo
     * @param format Formato "xml" ó "json"
     * @return Cadena serializada según sea formato: "xml" ó "json"
     */
    private String serializar(Vuelos vuelos, String format) {
        String result = null;

        try {
            // 1. Crea una instancia XStream dependiendo del tipo de formato de salida
            XStream contexto = null;

            switch (format) {
                case "xml":
                    // Crea una instancia XStream (usando el parser StAX)
                    contexto = new XStream(new StaxDriver());
                    break;

                case "json":
                    // Crea una instancia XStream (usando Jettison)
                    contexto = new XStream(new JettisonMappedXmlDriver());
                    break;

            }

            // 2. Vinculación de clases entre nombres de elementos
            contexto.alias("vuelos", Vuelos.class); // Objeto Vuelos -> Elemento <Vuelos>
            contexto.alias("vuelo", Vuelo.class); // Objeto Vuelo -> Elemento <Vuelo>

            // 3. Vinculación de la colección de objetos que contiene el atributo definido
            // como contenedor en la clase (nombre del atributo contenedor)
            contexto.addImplicitCollection(Vuelos.class, "vuelos");

            // 4. SERIALIZACIÓN (marshall) de la colección de objetos
            result = contexto.toXML(vuelos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        Vuelos v = new Vuelos();
        v.add(new Vuelo("Sevilla", "Salamanca"));

        // Serializar xml
        VuelosXStream serializar = new VuelosXStream();
        System.out.println(serializar.serializarXML(v));

        // Serializar Json
        System.out.println(serializar.serializarJSON(v));
    }
}