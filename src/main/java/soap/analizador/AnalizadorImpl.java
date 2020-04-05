package soap.analizador;

import javax.jws.WebService;
import java.util.Scanner;

@WebService(
        endpointInterface = "soap.analizador.Analizador",
        serviceName = "Analizador"
)

public class AnalizadorImpl implements Analizador{

    @Override
    public int palabras(String a) {
        int palabras=0;
        /*eliminamos aquello que no sea una letra o punto, por espacio*/
        a=a.replaceAll("[^A-Za-z]", " ");
        System.out.println(a);

        Scanner s = new Scanner(a);
        while(s.hasNext()){
            s.next();
            palabras++;
        }
        return(palabras);
    }

    @Override
    public int caracteres(String a) {
        return(a.length());
    }

    @Override
    public int frases(String a) {
        int frases=0;
        /*eliminamos aquello que no sea una letra o punto, por espacio*/
        a=a.replaceAll("[^A-Za-z.]", " ");
        System.out.println(a);
        for(int i=1;i<a.length();i++){
            if(a.charAt(i)=='.' && a.charAt(i-1)!='.')
                frases++;
        }

        if(a.charAt(a.length()-1)!='.')
            return(frases+1);
        else{
            return(frases);
        }

    }

    @Override
    public int vecesPalabra(String a, String palabra) {
        int veces=0;
        /*eliminamos aquello que no sea una letra, por espacio*/
        a=a.replaceAll("[^A-Za-z]", " ");
        System.out.println(a);
        Scanner s = new Scanner(a);
        while(s.hasNext()){
            if(s.next().equals(palabra))
                veces++;
        }
        return veces;
    }

    @Override
    public String palabraMasUsada(String a) {
        int veces=0;
        String palabra="";
        String aux;
        int aux2;

        a=a.replaceAll("[^A-Za-z]", " ");
        Scanner s = new Scanner(a);
        while(s.hasNext()){
            aux=s.next();
            aux2=this.vecesPalabra(a,aux);
            if(veces<aux2){
                veces=aux2;
                palabra=aux;
            }
        }
        return palabra;
    }

    @Override
    public String palabraMenosUsada(String a) {
        int veces=10000000;
        String palabra="";
        String aux;
        int aux2;

        a=a.replaceAll("[^A-Za-z]", " ");
        Scanner s = new Scanner(a);
        while(s.hasNext()){
            aux=s.next();
            aux2=this.vecesPalabra(a,aux);
            System.out.println(aux2);
            if(veces>aux2){
                veces=aux2;
                palabra=aux;
            }
        }
        return palabra;
    }

    @Override
    public String reemplazarPalabra(String a, String palabra1, String palabra2) {
        /*eliminamos aquello que no sea una letra, por espacio*/
        a=a.replaceAll(palabra1,palabra2);
        return a;
    }

}
