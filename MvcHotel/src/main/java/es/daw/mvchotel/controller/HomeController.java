package es.daw.mvchotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home"; // Redirige a la página home
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Devuelve la vista home.html
    }
}

