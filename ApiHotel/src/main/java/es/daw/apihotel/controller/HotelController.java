package es.daw.apihotel.controller;

import es.daw.apihotel.dto.HotelDto;
import es.daw.apihotel.entities.Habitacion;
import es.daw.apihotel.entities.Hotel;
import es.daw.apihotel.repository.HabitacionRepository;
import es.daw.apihotel.repository.HotelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    static HabitacionRepository habitacionRepository;
    static HotelRepository hotelRepository;

    @Autowired
     public HotelController(HotelRepository hotelRepository, HabitacionRepository habitacionRepository) {
        HotelController.hotelRepository = hotelRepository;
        HotelController.habitacionRepository = habitacionRepository;
    }

    @GetMapping("/listar")
    public List<Hotel>listarHoteles(){
        return hotelRepository.findAll();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Hotel>> buscarHotelPorCategoria(@PathVariable Integer categoria) {
        return ResponseEntity.ok(hotelRepository.findByCategoria(categoria));
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> crearHotel(@RequestBody @Valid HotelDto hotelDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String,String> errors = new HashMap<>();
            for(FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }


        Hotel hotel = new Hotel();
        hotel.setNombre(hotelDto.getNombre());
        hotel.setDescripcion(hotelDto.getDescripcion());
        hotel.setCategoria(hotelDto.getCategoria());
        hotel.setPiscina(hotelDto.getPiscina());
        hotel.setLocalidad(hotelDto.getLocalidad());

        hotelRepository.save(hotel);

        return ResponseEntity.ok(hotelDto);
    }




}
