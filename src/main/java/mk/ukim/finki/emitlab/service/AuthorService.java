package mk.ukim.finki.emitlab.service;


import mk.ukim.finki.emitlab.model.Author;
import mk.ukim.finki.emitlab.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(String name, String surname, Long countryId);
    void delete(Long id);
    Author update(Long id, String name, String surname, Long countryId);
}
