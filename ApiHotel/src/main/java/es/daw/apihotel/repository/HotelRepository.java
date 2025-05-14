package es.daw.apihotel.repository;

import es.daw.apihotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByCategoria(Integer hotelCategoria);
    Hotel findByNombre(String nombre);
}
