package mk.ukim.finki.emitlab.service;

import mk.ukim.finki.emitlab.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(String name, String continent);
    void delete(Long id);
    Country update(String name, String continent);
}
