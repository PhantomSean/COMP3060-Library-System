package ie.mcwebdeveloper.project.repositories;

import ie.mcwebdeveloper.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findById(long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Transactional
    @Modifying
    @Query("update User u set u.username = ?1, u.firstname = ?2, u.lastname = ?3, u.email = ?4, u.password = ?5 where u.id = ?6")
    int updateUser(String username, String firstname, String lastname, String email, String password, long id);
}