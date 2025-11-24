package ma.fstg.security.spring_security_jpa.repositories;

import ma.fstg.security.spring_security_jpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
