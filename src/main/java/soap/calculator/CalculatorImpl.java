package soap.calculator;

import javax.jws.WebService;
import java.util.Arrays;

/**
 * Implementación de la interfaz Calculator
 * @autor Pablo García Fernández.
 */

@WebService(
        endpointInterface = "soap.calculator.Calculator",
        serviceName = "Calculator"
)
public class CalculatorImpl implements Calculator {

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int resta(int a, int b) {
        return a-b;
    }

    @Override
    public int mult(int a, int b) {
        return a*b;
    }

    @Override
    public double div(int a, int b) {
        return ((double)a/b);
    }

    @Override
    public int pow(int a, int b) {
        int aux=1;
        for(int i=0;i<b;i++){
            if(i==0){
                aux=a;
            }else {
                aux = aux * a;
            }
        }
        return(aux);
    }

    @Override
    public double raiz2(int a) {
        if(a==0){
            return(0);
        }
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + a / res) / 2;
        }
        return res;
    }

    @Override
    public double ln(int a) {
        return 0;
    }

    @Override
    public int max(int[] nums) {
        return(0);
    }

    @Override
    public int min(int[] nums) {
        return 0;
    }

    @Override
    public double media(int[] nums) {
        return 0;
    }

    @Override
    public double mediana(int[] nums) {
        return 0;
    }

    @Override
    public int moda(int[] nums) {
        return 0;
    }

    @Override
    public double desviacionTipica(int[] nums) {
        return 0;
    }

}
