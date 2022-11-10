package ejercicio7;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.jaxen.JaxenException;

import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultasExamenAlumno {

    Scanner sc = new Scanner(System.in);
    private static File f = new File("res" + File.separator + "examen.xml");

    public static void main(String[] args) {
        try {
            // Número de preguntas contestadas
            System.out.println(ProcesadorXPath.consulta(f, "count(//respuesta)").toString());
            System.out.println("----------------------------------------");
            // Categorías relacionadas con la pregunta 3
            mostrarResultado("//cuestion[3]/categoria");
            // Categorías relacionadas con la penúltima pregunta
            mostrarResultado("//cuestion[last()-1]/categoria");
            // Cuestiones no respondidas
            mostrarResultado("//cuestion[not(respuesta)]/pregunta");
            // Respuestas ofrecidas por las cuestiones que haya superado más de 9 (inclusive)
            mostrarResultado("//cuestion[puntuacion >= 9]/respuesta");
            // Número de respuestas aprobadas (mayores de 5, inclusive)
            System.out.println(ProcesadorXPath.consulta(f, "count(//cuestion[puntuacion>=5]/respuesta)").toString());

        } catch (XPathExpressionException e) {
            System.err.println();
        } catch (FileNotFoundException e) {
            System.err.println();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (JaxenException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrarResultado(String consulta) throws DocumentException, JaxenException {
        List<Element> lista = (ArrayList<Element>) ProcesadorXPath.consultaJaxen(f, consulta);
        for (Element e : lista) {
            System.out.println(e.getText());
        }
        System.out.println("----------------------------------------");
    }
}
