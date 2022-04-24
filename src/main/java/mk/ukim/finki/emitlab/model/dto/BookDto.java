package mk.ukim.finki.emitlab.model.dto;

import lombok.Data;
import mk.ukim.finki.emitlab.model.Category;

import java.util.Calendar;

@Data
public class BookDto {

    private String name;
//    private Category category;
    private String category;
    private Long author;
    private Integer availableCopies;

    public BookDto(String name, String category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
