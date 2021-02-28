package cat.itb.m9.springboot.exemples.controladors.controladors.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ControladorMVC {
    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public String hola() {
        return "hola";
    }

    /* només pot haver un mapping per url i, evidentment, els noms dels mètodes
     * no poden estar repetits, a no ser que estiguin sobrecarregats, com és normal en Java */
    @GetMapping("/hola2")
    public String hola2() {
        return "hola";
    }

    // exemple d'ús de @RequestParam per passar paràmetres a la vista
    @GetMapping("/saluda1")
    //  public String saludarRequestParam(@RequestParam(name="nomParam",required = false, defaultValue = "Valor per defecte") String n, Model m){
    public String saludarRequestParam(@RequestParam("nom") String n, Model m) {
        //name="nom" significa que "nom" es el name del paràmetre en la URL
        //així el recurs es crida -> http://localhost:8080/saluda1?nom=Paquita
        //String n és la variable local que utilitzo en aquest mètode
        //"nomParam" és el nom de l'atribut que passo a la vista
        m.addAttribute("nomParam", n);
        return "/saluda1"; //retorna a la plantilla "saluda1.html"
    }

    @GetMapping("/saluda1optional")
    public String exemple2Bis(@RequestParam(name="nom") Optional<String> n, Model m){
        m.addAttribute("nomParam", n.orElse("Valor per defecte amb Optional"));
        return "/saluda1"; //retorna a la plantilla "saluda1.html"
    }


    // exemple d'ús @PathVariable per passar paràmetres a través de l'URL
    @GetMapping("/saluda2/{nom}")
    //per sol·licitar un recurs com /saluda2/{Paquita} //estil REST
    public String saludarPathVariable(@PathVariable("nom") String n, Model m) {
        m.addAttribute("nomParam", n);
        return "saluda2";
    }


}
