package soap.calculator;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

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
     * ln(a)=x == e^x=a
     * Al igual que el anterior, método de newton sobre la función:
     * f(x) = e^x-a
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
    /*si son impares, coger el del medio, si son pares la medio de los del medio*/
    public double mediana(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }
        nums=this.ordena(nums);
        if(nums.length%2==1){
            System.out.println(nums.length/2);
            return(nums[nums.length/2]);
        }
        else{
            return((nums[nums.length/2-1]+nums[nums.length/2])/2.0);
        }
    }

    @Override
    public int moda(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }

        int moda=-1;
        int maximoV=-1;

        for (int i = 0; i < nums.length; i++) {
            int veces = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    veces++;
            }
            if (veces > maximoV) {
                maximoV = veces;
                moda = nums[i];
            }
        }

        return(moda);
    }

    @Override
    /**
     * s=raiz((1/n)*sumatorio del cuadrado de las desviaciones respecto a la media)
     * Asumimos problacion completa -> el estadístico es n (no n-1)
     */
    public double desviacionTipica(int[] nums) throws ListaVaciaEception{
        if(nums==null || nums.length==0){
            throw new ListaVaciaEception("La lista no contiene ningún elemento");
        }

        double media = this.media(nums);
        double s=0;

        for(int e: nums){
            s += (e-media)*(e-media);
        }

        return(Math.sqrt(s/(nums.length*1.0)));
    }

    /**********************
     *  Métodos privados  *
     ******************** */
    private int[] ordena(int [] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i] + " ");
        }
        return(nums);
    }

}
