package ejercicio.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @Configuration
    public class ControlCalculadora{
       
        @Value("${app.message.error}")
        private String mensajeError;

        // @Value("${db.Server}")
        // private String server;

        // @Value("${db.user}")
        // private String user;
    

    @GetMapping("/suma/{a}/{b}")
    public respuesta sumarDigitos(@PathVariable int a,@PathVariable int b) {
        respuesta res = new respuesta();
        res.setA(a);
        res.setB(b);
        res.setResultado(a+b);

        return res;
    }

    // @GetMapping("/resta/{a}/{b}")
    // public int restar(@PathVariable int a,@PathVariable int b) {
    //     return a - b;
    // }
    @GetMapping("/resta/{a}/{b}")
    public respuesta restar(@PathVariable int a,@PathVariable int b) {
        respuesta res = new respuesta(a,b,a-b);
        return res;
    }


    // @GetMapping("/mult/{a}/{b}")
    // public int multriplicar(@PathVariable int a,@PathVariable int b) {
    //     return a * b;
    // }
    // @GetMapping("/mult/{a}/{b}")
    // public respuesta multriplicar(@PathVariable int a,@PathVariable int b) {
    //     return new respuesta(a,b,a*b);
    // }
    @GetMapping("/div/{a}/{b}")
    public respuesta dividir(@PathVariable int a,@PathVariable int b) {
        if (b==0){
            return new respuesta(a,b,"error en division por cero");
        }
      return new respuesta(a,b,a/b);
    }

    // @GetMapping("/getdb")
    // public String getInfo(){
    //     // return user + "," + server;
    // }

}
