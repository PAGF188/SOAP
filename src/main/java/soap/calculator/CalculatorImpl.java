package soap.calculator;

import javax.jws.WebService;

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
    /**
     * Dos posibles casos:
     *   -> b positivo:
     *      Multiplicamos a b veces. Almacenamos resultado en aux (inicializado a 1 para el caso b=0). En la primera
     *      iteración, aux=a (a^1=a).
     *
     *   -> b negativo:
     *      Multiplicamos 1/a b veces. El resto igual
     */
    public double pow(int a, int b) {
        double a_ = a;
        if(b<0){
            a_ = 1.0/a;
            b=-b;
        }

        double aux=1.0;
        for(int i=0;i<b;i++){
            if(i==0){
                aux=a_;
            }else {
                aux = aux * a_;
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
     * Traducido a nuestra función partícular -> x(n) = x(n-1) - ((x(n-1)*x(n-1)-a)/(2*x(n-1)))
     * x(n-1) = res;
     * Si la diferencia entre x(n-1) y x(n) es ínfima convergemos.
     * Si el número de pasos >= 500 convergemos -> asumimos precisión suficiente.
     */
    public double raiz2(int a) {
        int pasos=0;
        if(a==0){
            return(0);
        }
        else if(a<0){
            return(Double.NaN);
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
     * NO
     * f(x) = ln(x)
     * Aproximación de Taylor centrado en 1.
     * Derivadas:
     * f'(x) = 1/x
     * f''(x) = -1/x²
     * f'''(x) = 2/x³
     * f''''(x) = -6/x⁴
     * Regla general: f'n(x) = ((-1)^(n+1)*(n-1)!) / (x^n)
     * Taylor-> f'/f n!
     * 1+ sumatorio de n=1 hasta infinito (((-1)^(n+1))/(n*e^n))*(x-e)^n
     * Primer término queda alternando 1 y -1
     * Paramos si diferencia nula (entre 2 iterandos) o más de 500 pasos
     */
    public double ln(int a) {
        if(a<0){
            return(Double.NaN);
        }
        else if(a==0){
            return(Double.NEGATIVE_INFINITY);
        }
        int pasos=0;
        double save = 0.0;
        double res = 1.0;
        while ((res != save) && pasos<500) {
            save = res;
            res = res - ((Math.pow(e,res)-a)/(Math.pow(e,res)));
            pasos++;
        }
        return res;
    }

    @Override
    public int max(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        int max_ = nums[0];
        for(int i=1; i<nums.length;i++){
            if(nums[i]>max_)
                max_=nums[i];
        }
        return(max_);
    }

    @Override
    public int min(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        int min_ = nums[0];
        for(int i=1; i<nums.length;i++){
            if(nums[i]< min_)
                min_=nums[i];
        }
        return(min_);
    }

    @Override
    public double media(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        double suma = 0.0;
        for(int i=0;i<nums.length;i++){
            suma += nums[i];
        }
        return(suma/nums.length);
    }

    @Override
    public double mediana(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        return 0;
    }

    @Override
    public int moda(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        return 0;
    }

    @Override
    public double desviacionTipica(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        return 0;
    }
}
