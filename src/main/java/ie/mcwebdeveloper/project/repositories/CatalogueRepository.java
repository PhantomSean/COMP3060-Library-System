package ie.mcwebdeveloper.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.models.Catalogue;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
    Catalogue findById(long id);
}