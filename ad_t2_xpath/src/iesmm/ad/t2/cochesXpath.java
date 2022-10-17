package iesmm.ad.t2;

import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileNotFoundException;

public class cochesXpath {
    public static void main(String[] args) {
        File xml = new File("res" + File.separator + "coches.xml");

        if (xml.exists()){
            try {
                // Ejemplo 1
                System.out.println("****************************");
                String exp = "//coche[fabricante='Nissan']";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml,exp));

                // Ejemplo 2
                System.out.println("****************************");
                exp = "//coche[fabricante='Renault' and unidades>15]";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml,exp));

                // Ejemplo 3
                System.out.println("****************************");
                exp = "count(//coche)";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml,exp));

                // Ejemplo 4
                System.out.println("****************************");
                exp = "//coche[fabricante='Nissan'][precio>=1000 and precio<=1500]";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml,exp));

                // Ejemplo 5
                System.out.println("****************************");
                exp = "count(//coche[unidades>=10])";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml,exp));

            } catch (XPathExpressionException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("El fichero no existe");
        }
    }
}
