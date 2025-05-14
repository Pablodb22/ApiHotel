package es.daw.mvchotel.repository;

import es.daw.mvchotel.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
