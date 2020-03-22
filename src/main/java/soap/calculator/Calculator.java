package soap.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Interfaz de operaciones ofrecidas por el servicio Calculator.
 * @autor Pablo García Fernández.
 */

@WebService
public interface Calculator {

    /**
     * Operación 1: Suma de dos enteros.
     * @param a primer sumando entero.
     * @param b segundo sumando entero.
     * @return resultado de la suma.
     */
    @WebMethod(operationName = "suma")
    @WebResult(name = "resultado")
    int sum(@WebParam(name = "sumando1") int a, @WebParam(name = "sumando2") int b);

    /**
     * Operación 2: Resta de dos enteros
     * @param a primer operando.
     * @param b segundo operando.
     * @return resultado de la resta a-b.
     */
    @WebMethod(operationName = "resta")
    @WebResult(name = "resultado")
    int resta(@WebParam(name = "operando1") int a, @WebParam(name = "operando2") int b);

    /**
     * Operación 3: Multiplicación de dos enteros
     * @param a primer operando.
     * @param b segundo operando.
     * @return resultado de la multiplicación.
     */
    @WebMethod(operationName = "multiplicacion")
    @WebResult(name = "resultado")
    int mult(@WebParam(name = "operando1") int a, @WebParam(name = "operando2") int b);

    /**
     * Operación 4: División de dos enteros
     * @param a dividendo.
     * @param b divisor.
     * @return cociente (a/b).
     */
    @WebMethod(operationName = "division")
    @WebResult(name = "resultado")
    double div(@WebParam(name = "dividendo") int a, @WebParam(name = "divisor") int b);

    /**
     * Operación 5: Potencia de un número
     * @param a base.
     * @param b exponente
     * @return a elevado a b.
     */
    @WebMethod(operationName = "potencia")
    @WebResult(name = "resultado")
    double pow(@WebParam(name = "base") int a, @WebParam(name = "exponente") int b);

    /**
     * Operación 6: Raíz cuadrada de un número
     * @param a radicando. Entero positivo (devuelve 0 si no lo es).
     * @return raiz cuadrada de a.  NaN si a<0
     */
    @WebMethod(operationName = "raizCuadrada")
    @WebResult(name = "resultado")
    double raiz2(@WebParam(name = "radicando") int a);

    /**
     * Operación 7: Logaritmo neperiano de un número.
     * @param a valor al que calcular el ln. Entero positivo
     * @return valor tal que e^@return=a.  Nan si a<0. -Infinito si a==0
     */
    @WebMethod(operationName = "logNeperiano")
    @WebResult(name = "resultado")
    double ln(@WebParam(name = "operando") int a);

    /**
     * Operación 8: Máximo de una lista de números enteros
     * @param nums lista de valores enteros.
     * @return máximo de la lista. Nan en caso de lista vacía.
     */
    @WebMethod(operationName = "maximo")
    @WebResult(name = "maximo")
    int max(@WebParam(name = "lista") int [] nums) throws ListaVaciaEception;

    /**
     * Operación 9: Mínimo de una lista de números enteros
     * @param nums lista de valores enteros.
     * @return mínimo de la lista. Nan en caso de lista vacía.
     */
    @WebMethod(operationName = "minimo")
    @WebResult(name = "minimo")
    int min(@WebParam(name = "lista") int [] nums)throws ListaVaciaEception;

    /**
     * Operación 10: Media de una lista de numeros enteros
     * @param nums lista de valores enteros.
     * @return media. Nan en caso de lista vacía.
     */
    @WebMethod(operationName = "media")
    @WebResult(name = "media")
    double media(@WebParam(name = "lista") int [] nums) throws ListaVaciaEception;

    /**
     * Operación 11: Mediana de una lista de numeros enteros
     * @param nums lista de valores enteros.
     * @return mediana. Nan en caso de lista vacía.
     */
    @WebMethod(operationName = "mediana")
    @WebResult(name = "mediana")
    double mediana(@WebParam(name = "lista") int [] nums) throws ListaVaciaEception;

    /**
     * Operación 12: Moda de una lista de numeros enteros
     * @param nums lista de valores enteros.
     * @return moda. Nan en caso de lista vacía.
     */
    @WebMethod(operationName = "moda")
    @WebResult(name = "moda")
    int moda(@WebParam(name = "lista") int [] nums) throws ListaVaciaEception;

    /**
     * Operación 13: Desviación típica de una lista de numeros enteros
     * @param nums lista de valores enteros.
     * @return desviación típica. Nan en caso de lista vacía.
     */
    @WebMethod(operationName = "desviacionTipica")
    @WebResult(name = "desviacionTipica")
    double desviacionTipica(@WebParam(name = "lista") int [] nums) throws ListaVaciaEception;

    public class ListaVaciaEception extends Exception{
        public ListaVaciaEception(String m){
            super(m);
        }
    }

}
