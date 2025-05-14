package es.daw.mvchotel.repository;




import es.daw.mvchotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Siendo una interfaz, no necesitas la anotación @Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
