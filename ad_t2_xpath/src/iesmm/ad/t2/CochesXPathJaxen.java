package iesmm.ad.t2;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.jaxen.JaxenException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CochesXPathJaxen {
    public static void main(String args[]) throws Exception {
        File xml = new File("res" + File.separator + "coches.xml");

        if (xml.exists())
            try {
                // EJEMPLO 1
                System.out.println("*************************");
                String exp = "//coche/nombre";
                System.out.println(exp);
                List<Element> lista = (ArrayList<Element>) ProcesadorXPath.consultaJaxen(xml, exp);

                // Recorrido de la lista de elementos seleccionados
                for (Element elemento : lista)
                    System.out.println(elemento.asXML());

                // EJEMPLO 2: Nº de coches Nissan
                // OPCIÓN 1
                System.out.println("**************************");
                exp = "count(//coche[fabricante='Nissan'])";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consultaJaxen(xml, exp));

                // EJEMPLO 3: Elementos coches que tengan un número de unidades superior a 10
                System.out.println("**************************");
                exp = "//coche[unidades>10]/nombre";
                System.out.println(exp);
                lista = (ArrayList<Element>) ProcesadorXPath.consultaJaxen(xml, exp);
                for (Element coche : lista)
                    System.out.println(coche.asXML());

            } catch (DocumentException e) {
                System.err.println("-> Error en el parseo: " + e);
            } catch (JaxenException e) {
                System.err.println("-> Error en la expresión: " + e);
            } catch (Exception e) {
                System.err.println("-> Error: " + e);
            }
    }
}