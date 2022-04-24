package mk.ukim.finki.emitlab.config;


import lombok.Getter;
import mk.ukim.finki.emitlab.model.Author;
import mk.ukim.finki.emitlab.model.Book;
import mk.ukim.finki.emitlab.model.Category;
import mk.ukim.finki.emitlab.model.Country;
import mk.ukim.finki.emitlab.service.AuthorService;
import mk.ukim.finki.emitlab.service.BookService;
import mk.ukim.finki.emitlab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter
public class DataHolder {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;


    public DataHolder(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {

        Country contry1 = countryService.save("Makedonija", "Europe").get();
        Country contry2 =  countryService.save("Russian", "Europe").get();

        Author author1 = authorService.save("Blaze", "Koneski", contry1.getId()).get();
        Author author2 = authorService.save("Leo", "Koneski", contry2.getId()).get();

        bookService.save("Harry Potter", Category.FANTASY,  author1.getId(), 3);
        bookService.save("Game of Thrones", Category.FANTASY,  author2.getId(), 5);
    }
}
