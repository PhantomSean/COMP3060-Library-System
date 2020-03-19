package ie.mcwebdeveloper.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.mcwebdeveloper.project.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
}
