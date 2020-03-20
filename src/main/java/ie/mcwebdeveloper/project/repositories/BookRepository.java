package ie.mcwebdeveloper.project.repositories;

import ie.mcwebdeveloper.project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
    List<Book> findAllByUserid(long userid); // To find current loans
    @Query("select b from Book b where lower(b.title) like lower(concat('%', ?1,'%')) or lower(b.author) like lower(concat('%', ?1,'%'))")
    List<Book> findAllByTitleOrAuthorLike(String author);
}