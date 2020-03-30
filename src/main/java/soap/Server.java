package soap;

import soap.analizador.AnalizadorImpl;
import soap.analizador.Analizador;
import soap.calculator.Calculator;
import soap.calculator.CalculatorImpl;
import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        Calculator c = new CalculatorImpl();
        String address = "http://localhost:8080/calculator";
        Endpoint.publish(address, c);

        Analizador a = new AnalizadorImpl();
        String address2 = "http://localhost:8080/analizador";
        Endpoint.publish(address2, a);


    }
}
