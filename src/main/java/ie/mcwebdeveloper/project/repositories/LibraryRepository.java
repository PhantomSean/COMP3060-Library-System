package ie.mcwebdeveloper.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.models.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    
}