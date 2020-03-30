package soap.analizador;

import javax.jws.WebService;

@WebService(
        endpointInterface = "soap.analizador.Analizador",
        serviceName = "Analizador"
)

public class AnalizadorImpl implements Analizador{

    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
