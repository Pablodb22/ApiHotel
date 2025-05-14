package es.daw.mvchotel.controller;


import es.daw.mvchotel.dto.Habitacion;
import es.daw.mvchotel.dto.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private WebClient webClientHotel;

    @Autowired
    public HotelController(@Qualifier("webClientHotel") WebClient webClientHotel) {
        this.webClientHotel = webClientHotel;
    }

    @GetMapping("/listar")
    public String listarHotel(Model model) {


        List<Hotel> Hoteles = webClientHotel.get()
                .uri("/listar")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Hotel>>() {})
                .block();

        model.addAttribute("Hoteles",Hoteles);
        for (Hotel h : Hoteles) {
            System.out.println("********"+h);
        }


        return "/eventos/listaHot";
    }




}
