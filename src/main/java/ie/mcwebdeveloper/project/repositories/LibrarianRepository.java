package ie.mcwebdeveloper.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.models.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    
}