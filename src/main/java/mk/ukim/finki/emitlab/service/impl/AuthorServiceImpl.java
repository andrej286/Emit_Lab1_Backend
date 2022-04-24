package mk.ukim.finki.emitlab.service.impl;

import mk.ukim.finki.emitlab.model.Author;
import mk.ukim.finki.emitlab.model.Country;
import mk.ukim.finki.emitlab.repository.AuthorRepository;
import mk.ukim.finki.emitlab.repository.CountryRepository;
import mk.ukim.finki.emitlab.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Author> save(String name, String surname, Long countryId) {

        Country country1 = this.countryRepository.findById(countryId).get();
        this.authorRepository.deleteByName(name);

        return Optional.of(this.authorRepository.save(new Author(name,surname,country1)));
    }

    @Override
    public void delete(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Author update(Long id, String name, String surname, Long countryId) {

        Author author = this.authorRepository.findById(id).get();
        Country country = this.countryRepository.findById(countryId).get();
                author.setName(name);
                author.setSurname(surname);
                author.setCountry(country);
        return Optional.of(this.authorRepository.save(author)).get();
    }
}
