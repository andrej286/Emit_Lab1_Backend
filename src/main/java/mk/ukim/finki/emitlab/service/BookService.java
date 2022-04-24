package mk.ukim.finki.emitlab.service;

import mk.ukim.finki.emitlab.model.Author;
import mk.ukim.finki.emitlab.model.Book;
import mk.ukim.finki.emitlab.model.Category;
import mk.ukim.finki.emitlab.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> save(BookDto bookDto);
    void delete(Long id);
    Optional<Book> update(Long id, String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> update(Long id, BookDto bookDto);
    Optional<Book> subtractCopy(Long id);
}
