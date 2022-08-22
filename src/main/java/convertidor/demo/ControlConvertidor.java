package convertidor.demo;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Configuration

public class ControlConvertidor {

    @Value("${app.message.pesos}")
    private Double Pesos;

    @GetMapping("/pesos/{a}")
    public RespuestaConvertidor pesos(@PathVariable Double a) {
        RespuestaConvertidor respuesta = new RespuestaConvertidor();
        respuesta.setDolar(a * Pesos);
        respuesta.setPesos(a);
        return respuesta;
    }

    @GetMapping("/dolar/{a}")
    public RespuestaConvertidor dolar(@PathVariable Double a) {
        RespuestaConvertidor respuesta = new RespuestaConvertidor();
        respuesta.setPesos(a / Pesos);
        respuesta.setDolar(a);
        return respuesta;
    }

}
