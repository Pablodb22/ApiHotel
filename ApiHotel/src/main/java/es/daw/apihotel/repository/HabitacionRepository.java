package es.daw.apihotel.repository;

import es.daw.apihotel.entities.Habitacion;
import es.daw.apihotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    List<Habitacion> findByHotel(Hotel hotel);

    List<Habitacion> findByPrecioNoche(Double precioNoche);

    List<Habitacion> findByTamano(Double tamano);
}
