package ejercicio6;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;

public class ManejadorSAXCatalogo extends DefaultHandler {
    private String xmlResult;
    boolean esVideojuego = false;
    boolean esCaratula = false;
    private boolean esCaptura = false;
    private String caratula;

    public ManejadorSAXCatalogo() {
        xmlResult = "";
    }

    public String getXMLResult() {
        return xmlResult;
    }

    public void setXMLResult(String xmlResult) {
        this.xmlResult = xmlResult;
    }

    @Override
    public void endDocument() throws SAXException {
        xmlResult += "</tr></table></body></html>";
        try {
            System.out.println("Documento XML parseado correctamente");
            FileWriter escribir = new FileWriter("res" + File.separator + "parseadoCatalogo.html");
            escribir.write(xmlResult);
            escribir.close();

        } catch (Exception e) {
            System.err.println("Error general");
        }
    }

    @Override
    public void startDocument() throws SAXException {
        xmlResult += "<!DOCTYPE html><html><head><title>VideoJuegos</title></head><body><h1>CATÁLOGO DE VIDEOJUEGOS CLÁSICOS</h1><table border><tr>";
    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {
        if (esVideojuego) {
            switch (elemento) {
                case "titulo":
                    xmlResult += "</b></br>";
                    break;
                case "plataforma":
                    xmlResult += "</br>";
                    break;
                case "stock":
                    xmlResult += "</td>";
                    esVideojuego = false;
                    break;
            }
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        if (elemento.equals("videojuego")) {
            esVideojuego = true;
        } else if (esVideojuego) {
            switch (elemento) {
                case "titulo":
                    xmlResult += "<td><b>";
                    break;
                case "plataforma":
                    xmlResult += "Consola: ";
                    break;
                case "caratula":
                    esCaratula = true;
                    break;
                case "captura":
                    esCaptura = true;
                    break;
                case "stock":
                    xmlResult += "Stock actual: ";
                    break;
            }
        }
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        if (esVideojuego) {
            if (!esCaratula && !esCaptura) {
                xmlResult += new String(cadena, posinicio, longitud);
            } else if (esCaratula) {
                caratula = new String(cadena, posinicio, longitud);
                esCaratula = false;
            } else {
                esCaptura = false;
            }
        }
    }
}