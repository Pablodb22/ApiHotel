package es.daw.mvchotel.controller;


import es.daw.mvchotel.dto.Habitacion;
import es.daw.mvchotel.dto.HabitacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/habitacion")
public class HabitacionController {

    private final WebClient webClienteHabitacion;


    @Autowired
    public HabitacionController(@Qualifier("webClientHabitacion") WebClient webClienteHabitacion) {
        this.webClienteHabitacion = webClienteHabitacion;

    }

    @GetMapping("/listar")
    public String listarHabitacion(Model model) {
        System.out.println("**********Listar Habitacion**********");
        List<Habitacion> habitaciones = webClienteHabitacion.get()
                .uri("/listar")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Habitacion>>() {})
                .block();

        model.addAttribute("habitaciones",habitaciones);
         for (Habitacion habitacion : habitaciones) {
             System.out.println(habitacion);
         }
        System.out.println("**********Listar Habitacion 22**********");
        return "/eventos/listaHab";
    }

    @GetMapping("/borrar/{id}")
    public String borrarHabitacion(@PathVariable int id) {
        System.out.println("************HOLA************");
        Habitacion habitacion = webClienteHabitacion.delete().uri("/borrar/id/"+id).retrieve().bodyToMono(Habitacion.class).block();
        System.out.println("************HOLA22************");
        return "redirect:/habitacion/listar"; // Fix this line
    }

    @GetMapping("/modificar/{id}")
    public String modificarHabitacion(@PathVariable int id) {
        System.out.println("************HOLA**************");
        Habitacion habitacion=webClienteHabitacion.put().uri("/modificar/habitacionid/"+id).retrieve().bodyToMono(Habitacion.class).block();
        System.out.println("************HOLA22**************");
        return "redirect:/habitacion/listar";
    }

    @GetMapping("/nuevo")
    public String llevarFormulario(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "/eventos/formularioHab";
    }

    @PostMapping("/crear")
    public String crearHabitacion(Habitacion habitacion) {
        System.out.println("********"+habitacion+"*********");
        HabitacionRequest hReq=new HabitacionRequest();
        hReq.setTamano(habitacion.getTamano());
        hReq.setCapacidad(habitacion.getCapacidad());
        hReq.setPrecio(habitacion.getPrecioNoche());
        hReq.setIncluyeDesayuno(habitacion.getIncluyeDesayuno());
        hReq.setOcupado(habitacion.getOcupada());

        System.out.println("********"+hReq+"*********");

        webClienteHabitacion.post().uri("/nuevo/hotel/"+habitacion.getNombreHotel()).bodyValue(hReq).retrieve().bodyToMono(Habitacion.class).block();

        return "redirect:/habitacion/listar";
    }

}
