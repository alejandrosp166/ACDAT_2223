package ejercicio4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAXEmpleados extends DefaultHandler {
    private String xmlResult;
    int numeroEmpleados = 0;

    public ManejadorSAXEmpleados() {
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
        xmlResult += "\nNúmero de empleados: " + numeroEmpleados;
    }

    /**
     * COMIENZO DEL ELEMENTO
     */
    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        switch (elemento){
            case "nombre":
                xmlResult += "\n";
                break;
            case "Empleado":
                numeroEmpleados++;
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
        //System.out.println("Valor leido ->" + new String(cadena, posinicio, longitud));
        // OPCIÓN 1
        xmlResult += new String(cadena, posinicio, longitud) + " ";
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