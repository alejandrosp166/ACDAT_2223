package ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;

public class ManejadorSAX extends DefaultHandler {
    private String xmlResult;
    boolean esFoto = false;
    boolean esEmail = false;

    public ManejadorSAX() {
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
        xmlResult += "</table></body>";
    }

    @Override
    public void startDocument() throws SAXException {
        xmlResult += "<!DOCTYPE html><html><head><title>Empleados</title></head><body><table style=\"margin: 0 auto;\" border>";

    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {
        switch (elemento) {
            case "employee":
                xmlResult += "</tr>";
                break;
            default:
                if(elemento.equals("name") || elemento.equals("email") || elemento.equals("phone") || elemento.equals("mobile") || elemento.equals("extension")){
                    xmlResult += "</td>";
                }
                break;
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        switch (elemento) {
            case "employee":
                xmlResult += "<tr>@#~%&=}ç";
                break;
            case "photo":
                esFoto = true;
                break;
            default:
                if(elemento.equals("name") || elemento.equals("phone") || elemento.equals("mobile") || elemento.equals("extension") || elemento.equals("email")){
                    xmlResult += "<td>";
                }
                break;
        }
    }

    private void aniadirImagen(String img) {
        // Las rutas apuntan a la ruta absoluta para poder probarlo mejor durante el examen
        if(!new File("D:\\Proyectos IntelliJ\\ACDAT_2223\\acdt-t1y2-examen-alejandroseco\\" + img).exists()) {
            img = "D:\\Proyectos IntelliJ\\ACDAT_2223\\acdt-t1y2-examen-alejandroseco\\img\\anonymous.png";
        } else {
            img = img.replace("img/", "D:\\Proyectos IntelliJ\\ACDAT_2223\\acdt-t1y2-examen-alejandroseco\\img\\");
        }
        String[] temp = xmlResult.split("@#~%&=}ç");
        temp[0] += "<td><img src=\"" + img + "\"/></td>" + temp[1];
        xmlResult = temp[0];
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        if(!esFoto) {
            xmlResult += new String(cadena, posinicio, longitud);
        } else if (esFoto) {
            aniadirImagen(new String(cadena, posinicio, longitud));
            esFoto = false;
        }
    }
}