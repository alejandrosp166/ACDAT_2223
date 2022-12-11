package ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;

public class ManejadorSAXHTML extends DefaultHandler {
    int numTablas = 0;
    boolean flag = false;
    private String xmlResult;
    public ManejadorSAXHTML() {
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
        System.out.println("Documento XML parseado correctamente");
        xmlResult += "Número de tablas: " + numTablas;
    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {
        switch (elemento){
            case "table":
                xmlResult+="\n";
                break;
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        switch (elemento){
            case "table":
                numTablas++;
                break;
            case "td":
                flag = true;
                break;
            default:
                flag = false;
        }
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        if(flag) {
            xmlResult += new String(cadena, posinicio, longitud) + " ";
        }
    }
}