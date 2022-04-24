package mk.ukim.finki.emitlab.repository;

import mk.ukim.finki.emitlab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    void deleteByName(String name);
}
