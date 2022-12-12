package ejercicio3;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.jaxen.JaxenException;

import java.io.File;
import java.util.List;

public class ConsultasHTML {
    public static void main(String[] args) {
        File xml = new File("res" + File.separator + "mihtml.xml");

        if (xml.exists()){
            try {
                // Número de tablas existentes
                Number n = ProcesadorXPath.consultaJaxenCount(xml, "count(//table)");
                System.out.println(n);
                System.out.println("-------------------------");
                // Celdas existentes por cada una de las tablas
                List<Element> lista = (List<Element>) ProcesadorXPath.consultaJaxen(xml,"//table/tr/td");
                for (Element e: lista){
                    System.out.println(e.getText());
                }
                System.out.println("-------------------------");
                // Primera fila de cada tabla
                lista = (List<Element>) ProcesadorXPath.consultaJaxen(xml, "//table/tr[position()=1]");
                for (Element e: lista){
                    System.out.println(e.asXML());
                }
                System.out.println("-------------------------");
                // Número de tablas que contienen el valor celdaB1
                System.out.println(ProcesadorXPath.consultaJaxen(xml, "count(//table/tr[td='Celda B1'])"));
                // Número de filas que contienen al menos 2 celdas
                System.out.println(ProcesadorXPath.consultaJaxen(xml, "count(//table/tr[count(td)>=2])"));
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (JaxenException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
