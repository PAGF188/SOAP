package soap.calculator;

import javax.jws.WebService;
import java.lang.Math.*;

/**
 * Implementación de la interfaz Calculator
 * @autor Pablo García Fernández.
 */

@WebService(
        endpointInterface = "soap.calculator.Calculator",
        serviceName = "Calculator"
)
public class CalculatorImpl implements Calculator {

    public static final double e = 2.718281828459;

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
    /**
     * Método Newton Raphson
     * f(x) = x²-a
     * f'(x) = 2x
     * x(n) = x(n-1) - (f(n-1)/f'(n-1))
     * x(n) = x(n-1) - ((x(n-1)*x(n-1)-a)/(2*x(n-1)))
     * x(n-1) = res;
     * Si la diferencia entre x(n-1) y x(n) es ínfima convergemos.
     * Si el número de pasos >= 500 convergemos -> asumimos precisión suficiente.
     */
    public double raiz2(int a) {
        int pasos=0;
        if(a==0){
            return(0);
        }
        double save = 0.0;
        double res = 1.0;
        while ((res != save) && pasos<=500) {
            save = res;
            res = res - ((res*res-a)/(2*res));
            pasos++;
        }
        return res;
    }

    @Override
    /**
     * f(x) = ln(x)
     * Aproximación de Taylor centrado en 1.
     * Derivadas:
     * f'(x) = 1/x
     * f''(x) = -1/x²
     * f'''(x) = 2/x³
     * f''''(x) = -6/x⁴
     * Regla general: f'n(x) = ((-1)^(n+1)*(n-1)!) / (x^n)
     * Taylor-> f'/f
     * 1+ sumatorio de n=1 hasta infinito (((-1)^(n+1))/(n*e^n))*(x-e)^n
     * Primer término queda alternando 1 y -1
     */
    public double ln(int a) {
        if(a==0){
            return(-1.0);
        }
        int n=1;
        double save = 0.0;
        double res = 1.0;
        boolean par = true;

        while(( res != save) && n<=500){
            save = res;
            if(par==true){
                res = res + (1.0/(n*Math.pow(e,n))) * (Math.pow(a-e,n));
                par=false;
            }
            else if(par==false){
                res = res + (-1.0/(n*Math.pow(e,n))) * (Math.pow(a-e,n));
                par=true;
            }
            n++;
        }
        return(res);
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
