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
        System.out.println("Pow: " + client.pow(0,5));
        System.out.println("Pow: " + client.pow(5,0));
        System.out.println("Pow: " + client.pow(5,8));
        System.out.println("Pow: " + client.pow(5,1));
        System.out.println("Pow: " + client.pow(1,5));
        System.out.println("Raix: " + client.raiz2(98));
        System.out.println("hola 2 commit");
    }
}
