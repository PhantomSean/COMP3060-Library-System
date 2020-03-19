package ie.mcwebdeveloper.project.repositories;

import ie.mcwebdeveloper.project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
    List<Book> findAllByUserid(long userid); // To find current loans
}