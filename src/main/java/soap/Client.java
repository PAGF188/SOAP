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
            sc.reset();
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

            }
        }

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
        System.out.println("Raiz -5: " + client.raiz2(-5));
        System.out.println("Raiz 198: " + client.raiz2(198));
        System.out.println("Raiz 51912: " + client.raiz2(51912));


        System.out.println("");

        /**/
        System.out.println("Ln(5) = " + client.ln(5));
        System.out.println("Ln(45) = " + client.ln(45));
        System.out.println("Ln(67) = " + client.ln(67));
        System.out.println("Ln(0) = " + client.ln(0));
        System.out.println("Ln(-2) = " + client.ln(-2));

        /**/
        int x[] = {};
        int n[] = {5,6,12,32,1,6,9,33,2,4,55,6,7,1,2,4,22,4,211,1,67,21,34,23,-444};
        int m[] = {4,5,3,6,1,2,1};
        int t[] = {4,5,3,6,1,2,6};
        int mi[] = {5,5,4,3,1,1,2};
        try {
            System.out.println("\nMaximo Lista: " + client.max(n));
            System.out.println("Minimo Lista: " + client.min(n));
            System.out.println("Media Lista: " + client.media(n));
            System.out.println("Máximo con lista vacía: " + client.max(x));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        /**/
        try{
            System.out.println("\nMediana(3.5) "+client.mediana(m));
            System.out.println("Mediana(3) "+client.mediana(mi));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        /*moda, moda moda*/
        try{
            System.out.println("\nModa(1) "+client.moda(m));
            System.out.println("Moda(6) "+client.moda(t));
            System.out.println("Moda(1-5) "+client.moda(mi));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        /*desviacion desviacion desviacion*/
        try{
            System.out.println("\nDesviacion(1) "+client.desviacionTipica(m));
            System.out.println("Desviacion(6) "+client.desviacionTipica(t));
            System.out.println("Desviacion(1-5) "+client.desviacionTipica(mi));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        /*PRUEBA ANALIZADOR*/
        /*PRUEBA ANALIZADOR*/
        /*PRUEBA ANALIZADOR*/
        /*PRUEBA ANALIZADOR*/
        /*PRUEBA ANALIZADOR*/


        System.out.println("\nNumero de palabras: " + analizador.palabras("  Hola   yo me llamo . Pablo y  ; tu  ?   "));
        System.out.println("Caracteres: " + analizador.caracteres("Hola asd alsd .a,as.dk ñlasdpàiosdad_"));
        System.out.println("Frases: " + analizador.frases("ajkskdlkasdasd....."));
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
