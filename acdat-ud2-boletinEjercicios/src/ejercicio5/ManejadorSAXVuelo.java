package ejercicio5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;

public class ManejadorSAXVuelo extends DefaultHandler {
    private String xmlResult;
    public ManejadorSAXVuelo() {
        xmlResult = "";
    }

    public String getXMLResult() {
        return xmlResult;
    }

    public void setXMLResult(String xmlResult) {
        this.xmlResult = xmlResult;
    }

    @Override
    public void startDocument() throws SAXException {
        xmlResult += "<!DOCTYPE html>\n" +
                "<html>" +
                "<head>" +
                "<title>Listado de vuelos</title>" +
                "</head>" +
                "<body>" +
                "<h1>LISTADO DE VUELOS</h1>" +
                "<table border><tr><th>ORIGEN</th><th>DESTINO</th></tr>\n";
    }

    @Override
    public void endDocument() throws SAXException {
        xmlResult += "</table></body></html>";
        try {
            System.out.println("Documento XML parseado correctamente");
            FileWriter escribir = new FileWriter("res" + File.separator + "parseado.html");
            escribir.write(xmlResult);
            escribir.close();

        } catch (Exception e) {
            System.err.println("Error general");
        }
    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {
        refact(elemento, "/");
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        refact(elemento, "");
    }

    private void refact(String elemento, String slash) {
        if (elemento.equals("origen") || elemento.equals("destino")) {
            xmlResult += "<" + slash + "td>";
        } else if (elemento.equals("Vuelo")) {
            xmlResult += "<" + slash + "tr>";
        }
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        xmlResult += new String(cadena, posinicio, longitud);
    }
}