package ie.mcwebdeveloper.project.repositories;

import ie.mcwebdeveloper.project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
}