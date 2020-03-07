package ie.mcwebdeveloper.project.repositories;

import ie.mcwebdeveloper.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
}
