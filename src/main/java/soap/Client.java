package soap;

import soap.calculator.Calculator;
import soap.analizador.Analizador;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8080/calculator?wsdl");
        QName SERVICE_NAME = new QName("http://calculator.soap/", "Calculator");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        Calculator client = service.getPort(Calculator.class);

        URL wsdlURL2 = new URL("http://localhost:8080/analizador?wsdl");
        QName SERVICE_NAME2 = new QName("http://analizador.soap/", "Analizador");
        Service service2 = Service.create(wsdlURL2, SERVICE_NAME2);
        Analizador analizador = service2.getPort(Analizador.class);

        Scanner sc = new Scanner(System.in);
        int opcion=-1;

        while(opcion!=0) {
            System.out.println("------------ CLIENTE ------------");
            System.out.println("->0:salir");
            System.out.println("->1:sumar");
            System.out.println("->2:restar");
            System.out.println("->3:multiplicar");
            System.out.println("->4:dividir");
            System.out.println("->5:potencia");
            System.out.println("->6:raiz");
            System.out.println("->7:logaritmo");
            System.out.println("->8:máximo");
            System.out.println("->9:mínimo");
            System.out.println("->10:media");
            System.out.println("->11:mediana");
            System.out.println("->12:moda");
            System.out.println("->13:desviacion");
            System.out.println("->14:contar palabras");
            System.out.println("->15:contar caracteres");
            System.out.println("->16:contar frases");
            System.out.println("->17:veces palabra");
            System.out.println("->18:palabra mas usada");
            System.out.println("->19:palabra menos usada");
            System.out.println("->20:reemplazar palabra");
            System.out.println("------------ CLIENTE ------------");

            System.out.println("Inserta opción: ");
            opcion=sc.nextInt();
            int a,b;
            String linea;
            String palabra;
            String palabra2;
            int lista[];

            switch (opcion){
                case 1:
                    System.out.println("Sumandos: ");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    System.out.println(a + "+" + b + "=" + client.sum(a,b));
                    break;
                case 2:
                    System.out.println("Sumandos: ");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    System.out.println(a + "-" + b + "=" + client.resta(a,b));
                    break;
                case 3:
                    System.out.println("Multiplicandos: ");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    System.out.println(a + "x" + b + "=" + client.mult(a,b));
                    break;
                case 4:
                    System.out.println("Dividendo dvisor: ");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    System.out.println(a + "/" + b + "=" + client.div(a,b));
                    break;
                case 5:
                    System.out.println("Base exponente: ");
                    a=sc.nextInt();
                    b=sc.nextInt();
                    System.out.println(a + "^" + b + "=" + client.pow(a,b));
                    break;
                case 6:
                    System.out.println("Valor: ");
                    a=sc.nextInt();
                    System.out.println("Raiz " + a + "=" + client.raiz2(a));
                    break;
                case 7:
                    System.out.println("Valor: ");
                    a=sc.nextInt();
                    System.out.println("Ln(" + a + ")=" + client.ln(a));
                    break;
                case 8:
                    System.out.println("Lista de numeros (separados con comas): ");
                    linea=sc.next();
                    lista=lista(linea);
                    try {
                        System.out.println("Mayor elemento de la lista: " + client.max(lista));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Lista de numeros (separados con comas): ");
                    linea=sc.next();
                    lista=lista(linea);
                    try {
                        System.out.println("Mínimo elemento de la lista: " + client.min(lista));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Lista de numeros (separados con comas): ");
                    linea=sc.next();
                    lista=lista(linea);
                    try {
                        System.out.println("Media de la lista: " + client.media(lista));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    System.out.println("Lista de numeros (separados con comas): ");
                    linea=sc.next();
                    lista=lista(linea);
                    try {
                        System.out.println("Mediana de la lista: " + client.mediana(lista));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    System.out.println("Lista de numeros (separados con comas): ");
                    linea=sc.next();
                    lista=lista(linea);
                    try {
                        System.out.println("Moda de la lista: " + client.moda(lista));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 13:
                    System.out.println("Lista de numeros (separados con comas): ");
                    linea=sc.next();
                    lista=lista(linea);
                    try {
                        System.out.println("Desviación típica: " + client.desviacionTipica(lista));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 14:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Nº palabras: " + analizador.palabras(linea));
                    break;
                case 15:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Nº caracteres: " + analizador.caracteres(linea));
                    break;
                case 16:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Nº frases: " + analizador.frases(linea));
                    break;
                case 17:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Inserta palabra a buscar:");
                    palabra=sc.next();
                    System.out.println("Veces que aparece " + palabra + " : " + analizador.vecesPalabra(linea,palabra));
                    break;
                case 18:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Palabra más usada: " + analizador.palabraMasUsada(linea));
                    break;
                case 19:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Palabra menos usada: " + analizador.palabraMenosUsada(linea));
                    break;
                case 20:
                    sc.nextLine();
                    System.out.println("Inserta texto:");
                    linea=sc.nextLine();
                    System.out.println("Palabra a reemplazar:");
                    palabra=sc.nextLine();
                    System.out.println("Palabra reemplazadora:");
                    palabra2=sc.nextLine();
                    System.out.println(analizador.reemplazarPalabra(linea,palabra,palabra2));
                    break;
            }
            //sc.nextLine();
        }
    }

    private static int[] lista(String linea){
        String[] digitos =  linea.split(",");

        int[] resultado = new int[digitos.length];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = Integer.parseInt(digitos[i].trim());
        }
        return(resultado);
    }
}
