package soap.analizador;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface Analizador {

    /**
     * Operación1: Contar palabras
     * @param a, texto insertado por el usuario
     * @return número de palabras que integran el texto
     */
    @WebMethod(operationName = "contarPalabras")
    @WebResult(name = "palabras")
    int palabras(@WebParam(name = "text") String a);

    /**
     * Operación2: Contar caracteres (incluyendo espacios, signos de puntuación, etc.)
     * @param a, texto insertado por el usuario
     * @return, número de caracteres que integran el texto
     */
    @WebMethod(operationName = "contarCaracteres")
    @WebResult(name = "palabras")
    int caracteres(@WebParam(name = "text") String a);

    /**
     * Operación3: Contar frases
     * @param a, texto insertado por el usuario
     * @return, número de frases que contiene el texto
     */
    @WebMethod(operationName = "contarFrases")
    @WebResult(name = "frases")
    int frases(@WebParam(name = "text") String a);

    /**
     * Operación4: Número de veces que aparece una palabra.
     * @param a, texto insertado por el usuario
     * @param palabra, palabra a contar
     * @return, número de veces que aparece palabra en a.
     */
    @WebMethod(operationName = "vecesPalabra")
    @WebResult(name = "vecesPalabra")
    int vecesPalabra(@WebParam(name = "text") String a, @WebParam(name = "palabra") String palabra);

    /**
     * Operación5: Palabra más usada.
     * @param a, texto insertado por el usuario
     * @return, palabra más repetida.
     */
    @WebMethod(operationName = "palabraMasUsada")
    @WebResult(name = "palabraMasUsada")
    String palabraMasUsada(@WebParam(name = "text") String a);

    /**
     * Operación6: Palabra menos usada.
     * @param a, texto insertado por el usuario
     * @return, palabra menos repetida.
     */
    @WebMethod(operationName = "palabraMenosUsada")
    @WebResult(name = "palabraMenosUsada")
    String palabraMenosUsada(@WebParam(name = "text") String a);

    /**
     * Operación7: Reemplazar palabra.
     * @param a, texto insertado por el usuario
     * @param palabra, palabra a reemplazar
     * @return, texto con la palabra reemplazada
     */
    @WebMethod(operationName = "reemplazarPalabra")
    @WebResult(name = "textoVuelta")
    String reemplazarPalabra(@WebParam(name = "text") String a, @WebParam(name = "palabra") String palabra);








}
