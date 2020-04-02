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
        Scanner s = new Scanner(a);
        while(s.hasNext()){
            if(this.validar(s.next()))
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
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='.')
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
        return 0;
    }

    @Override
    public String palabraMasUsada(String a) {
        return null;
    }

    @Override
    public String palabraMenosUsada(String a) {
        return null;
    }

    @Override
    public String reemplazarPalabra(String a, String palabra) {
        return null;
    }

    private boolean validar(String x){
        if(x.equals("!") | x.equals("?") | x.equals(".") | x.equals("¿") | x.equals("¡")
        | x.equals(",") | x.equals(";") | x.equals("-")){
            return(false);
        }
        else{
            return(true);
        }
    }


}
