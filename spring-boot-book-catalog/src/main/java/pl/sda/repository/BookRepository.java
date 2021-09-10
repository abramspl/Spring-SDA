package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Book;

@Repository //jest opcjonalna
public interface BookRepository extends JpaRepository<Book, Integer> {

}
