package ejercicio4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAXSesiones extends DefaultHandler {
    private String xmlResult;
    int numeroEmpleados = 0;

    public ManejadorSAXSesiones() {
        xmlResult = "";
    }

    public String getXMLResult() {
        return xmlResult;
    }

    public void setXMLResult(String xmlResult) {
        this.xmlResult = xmlResult;
    }

    // SOBRECARGA DE EVENTOS DE LA CLASE HANDLER

    /**
     * INICIO DEL DOCUMENTO XML
     */
    @Override
    public void startDocument() throws SAXException {

    }

    /**
     * FIN DEL DOCUMENTO XML
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Documento XML parseado correctamente");
    }

    /**
     * COMIENZO DEL ELEMENTO
     */
    boolean noMostrarHoras = true;
    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        switch (elemento){
            case "username":
                xmlResult += "\n";
                break;
            case "password":
                xmlResult += ":";
                break;
            default:
                if (elemento.equals("horainicio") || elemento.equals("horafinal")){
                    noMostrarHoras = false;
                }
                break;
        }
    }

    /**
     * FIN DEL ELEMENTO
     */
    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {

    }

    /**
     * CADENA DE CARACTERES (VALOR DEL CONTENIDO)
     *
     * @param cadena    Cadena de caracteres extraída del elemento como valor
     *                  específico
     * @param posinicio Posición del caracter dentro del documento XML
     * @param longitud  Número de carácteres
     * @throws SAXException Cualquier excepción producida en la lectura del valor
     */

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        if (noMostrarHoras) {
            xmlResult += new String(cadena, posinicio, longitud);
        }
        noMostrarHoras = true;
    }

    /**
     * CADENA DE CARACTERES EN BLANCO (solo cuando la DTD esté incluida como
     * recurso o dentro del mismo documento)
     *
     * @param cadena    Cadena de caracteres extraída del elemento como valor
     *                  específico
     * @param posinicio Posición del caracter dentro del documento XML
     * @param longitud  Número de carácteres
     * @throws SAXException Cualquier excepción producida en la lectura del valor
     */
    public void ignorableWhitespace(char[] cadena, int posinicio, int longitud) throws SAXException {
        // System.out.println("Es un blanco");
    }
}