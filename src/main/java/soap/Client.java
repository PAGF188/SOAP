package soap;

import soap.calculator.Calculator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8080/calculator?wsdl");
        QName SERVICE_NAME = new QName("http://calculator.soap/", "Calculator");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        Calculator client = service.getPort(Calculator.class);
        System.out.println("Suma: " + client.sum(5,10));
        System.out.println("Resta" + client.resta(5,10));
        System.out.println("Multi: " + client.mult(5,10));
        System.out.println("Divv: " + client.div(0,0));
        System.out.println("Divv: " + client.div(3,0));
        System.out.println("");

        System.out.println("Pow 0^5: " + client.pow(0,5));
        System.out.println("Pow:5^0 " + client.pow(5,0));
        System.out.println("Pow:5^8 " + client.pow(5,8));
        System.out.println("Pow:5^1 " + client.pow(5,1));
        System.out.println("Pow:1^5 " + client.pow(1,5));
        System.out.println("Pow:4^-3 " + client.pow(4,-3));
        System.out.println("Pow:4^-1 " + client.pow(4,-1));
        System.out.println("Pow:4^-0 " + client.pow(4,-0));
        System.out.println("Pow:-4^3 " + client.pow(-4,3));
        System.out.println("Pow:-4^4 " + client.pow(-4,4));
        System.out.println("Pow:-4^-3 " + client.pow(-4,-3));
        System.out.println("Pow:-4^-4 " + client.pow(-4,-4));

        /**/
        System.out.println("");
        System.out.println("Raiz 4:" + client.raiz2(4));
        System.out.println("Raiz 12:" + client.raiz2(12));
        System.out.println("Raiz 64: " + client.raiz2(64));
        System.out.println("Raiz 1:" + client.raiz2(1));
        System.out.println("Raiz 0:" + client.raiz2(0));
        System.out.println("Raiz -5:" + client.raiz2(-5));
        System.out.println("");

        /**/
        System.out.println("Ln(5) = " + client.ln(5));
        System.out.println("Ln(0) = " + client.ln(0));
        System.out.println("Ln(-2) = " + client.ln(-2));

        /**/
        int x[] = {};
        int n[] = {5,6,12,32,1,6,9,33,2,4,55,6,7,1,2,4,22,4,211,1,67,21,34,23};
        try {
            System.out.println("\nMaximo Lista: " + client.max(n));
            System.out.println("Minimo Lista: " + client.min(n));
            System.out.println("Media Lista: " + client.media(n));
            System.out.println("Máximo con lista vacía: " + client.max(x));
        }catch (Calculator.ListaVaciaEception e){
            System.out.println(e.getMessage());
        }


    }
}
