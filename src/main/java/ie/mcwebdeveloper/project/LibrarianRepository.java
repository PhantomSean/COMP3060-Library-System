package ie.mcwebdeveloper.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    
}