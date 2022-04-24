package mk.ukim.finki.emitlab.service.impl;

import mk.ukim.finki.emitlab.model.Author;
import mk.ukim.finki.emitlab.model.Book;
import mk.ukim.finki.emitlab.model.Category;
import mk.ukim.finki.emitlab.model.dto.BookDto;
import mk.ukim.finki.emitlab.repository.AuthorRepository;
import mk.ukim.finki.emitlab.repository.BookRepository;
import mk.ukim.finki.emitlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {

        Author author = this.authorRepository.findById(authorId).get();
        this.bookRepository.deleteByName(name);

        return  Optional.of(this.bookRepository.save(new Book(name,category,author,availableCopies)));
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> update(Long id, String name, Category category, Long authorId, Integer availableCopies) {

        Author author = this.authorRepository.findById(authorId).get();

        Book book = this.bookRepository.findById(id).get();
                  book.setName(name);
                  book.setCategory(category);
                  book.setAuthor(author);
                  book.setAvailableCopies(availableCopies);
        return Optional.of(this.bookRepository.save(book));

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor()).get();
        this.bookRepository.deleteByName(bookDto.getName());

        //TODO smeneto e
//        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        Book book = new Book(bookDto.getName(), Category.valueOf(bookDto.getCategory().toUpperCase()), author, bookDto.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).get();
        Author author = this.authorRepository.findById(bookDto.getAuthor()).get();

        book.setName(bookDto.getName());
        //TODO smeneto e
//        book.setCategory(bookDto.getCategory());
        book.setCategory(Category.valueOf(bookDto.getCategory().toUpperCase()));

        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> subtractCopy(Long id) {

        Book book = this.bookRepository.findById(id).get();
        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);

        return Optional.of(book);
    }

}