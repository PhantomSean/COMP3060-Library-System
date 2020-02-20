package ie.mcwebdeveloper.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    
}