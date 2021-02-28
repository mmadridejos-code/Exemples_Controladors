package cat.itb.m9.springboot.exemples.controladors.controladors.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/* Un Controlador REST pot retornar qualsevol tipus de dada
 * normalment un JSON (S'utilitza internament la conversió amb la llibreria Jackson)
 */
@RestController
public class ControladorREST {

    // 1) exemple que l'URL retorna un enter
    @GetMapping("/numero")
    public int numero(){
        return new Random().nextInt(10);
    }

    // 2) exemple que l'URL retorna un String
    @GetMapping("/hola_rest")
    public String hello(@RequestParam(value="nom", defaultValue="Món") String n){
        return "Hola "+n;
    }

    // 3) exemple que l'URL retorna la conversió a JSON d'un objecte de la classe Greeting
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}
