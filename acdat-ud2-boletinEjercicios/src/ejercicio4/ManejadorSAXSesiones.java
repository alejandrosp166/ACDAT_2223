package ejercicio4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;

public class ManejadorSAXSesiones extends DefaultHandler {
    private String xmlResult;
    boolean noMostrarHoras;

    public ManejadorSAXSesiones() {
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

    }

    @Override
    public void endDocument() throws SAXException {
        try {
            System.out.println("Documento XML parseado correctamente");
            FileWriter escribir = new FileWriter("res" + File.separator + "gestionarSesiones.txt");
            escribir.write(xmlResult);
            escribir.close();

        } catch (Exception e) {
            System.err.println("Error general");
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        if (elemento.equals("horainicio") || elemento.equals("horafinal")){
            noMostrarHoras = true;
        } else {
            noMostrarHoras = false;
        }
    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {
        switch (elemento) {
            case "username":
                xmlResult += ":";
                break;
            case "password":
                xmlResult += "\n";
                break;
        }
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        if (!noMostrarHoras) {
            xmlResult += new String(cadena, posinicio, longitud);
        }
    }
}