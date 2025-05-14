package es.daw.apihotel.controller;

import es.daw.apihotel.entities.Habitacion;
import es.daw.apihotel.entities.Hotel;
import es.daw.apihotel.repository.HabitacionRepository;
import es.daw.apihotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    private static HabitacionRepository habitacionRepository;
    private static HotelRepository hotelRepository;

    @Autowired
     public HabitacionController(HabitacionRepository habitacionRepository, HotelRepository hotelRepository) {
        this.habitacionRepository = habitacionRepository;
        this.hotelRepository = hotelRepository;
    }


    @GetMapping("/listar")
    public List<Habitacion> getAllHabitacion() {
        return habitacionRepository.findAll();
    }

    @GetMapping("/hotel/{nom_hotel}/tamano/{tamano}/precio/{precio}")
    public ResponseEntity<List<Habitacion>> buscarHabitacionPorPrecioyTamano(@PathVariable String nom_hotel, @PathVariable Integer tamano, @PathVariable BigDecimal precio) {


        Hotel h=hotelRepository.findByNombre(nom_hotel); //Informacion del hotel que he buscado

        List<Habitacion> habitaciones=habitacionRepository.findByHotel(h); //Aqui tengo las habitaciones del hotel que he buscado

        List<Habitacion>habitaiconesMostrar=new ArrayList<>();

        for (Habitacion habitacion: habitaciones){
            if(habitacion.getTamano().equals(tamano)){
                if(habitacion.getPrecioNoche().equals(precio)){
                    habitaiconesMostrar.add(habitacion);
                }
            }
        }

        return ResponseEntity.ok(habitaiconesMostrar);

    }

    @DeleteMapping("/borrar/id/{id}")
    public ResponseEntity<Habitacion> borrarHabitacion(@PathVariable Integer id) {
        Optional<Habitacion> habitacion=habitacionRepository.findById(id);
        habitacionRepository.delete(habitacion.get());
        return ResponseEntity.ok(habitacion.get());
    }

    @PostMapping("/nuevo/hotel/{nom_hotel}")
    public ResponseEntity<?>crearHabitacion(@RequestBody Habitacion habitacion, @PathVariable String nom_hotel) {
          Hotel h=hotelRepository.findByNombre(nom_hotel);
          habitacion.setHotel(h);
          habitacionRepository.save(habitacion);
          return ResponseEntity.ok(habitacion);
    }

    @DeleteMapping("/eliminar/hotel/{nom_hotel}/habitacionid/{habitacionid}")
    public ResponseEntity<List<Habitacion>> borrarHabitacionHotel(@PathVariable String nom_hotel, @PathVariable Integer habitacionid) {
        Hotel h=hotelRepository.findByNombre(nom_hotel);
        Habitacion habitacion=habitacionRepository.findById(habitacionid).get();

        if(habitacion.getHotel().equals(h)){
            habitacionRepository.delete(habitacion);
        }

        return ResponseEntity.ok(habitacionRepository.findAll());
    }

    @PutMapping("/modificar/habitacionid/{habitacionid}")
    public ResponseEntity<Habitacion> modificarHabitacion( @PathVariable Integer habitacionid) {
        Optional<Habitacion> h=habitacionRepository.findById(habitacionid);

        if(h.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Habitacion habitacion=h.get();
        habitacion.setOcupada(true);
        habitacionRepository.save(habitacion);
        return ResponseEntity.ok(habitacion);
    }
}
