package mk.ukim.finki.emitlab.service.impl;

import mk.ukim.finki.emitlab.model.Country;
import mk.ukim.finki.emitlab.repository.CountryRepository;
import mk.ukim.finki.emitlab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return Optional.of(countryRepository.save(new Country(name,continent)));
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country update(String name, String continent) {

        Country country = new Country(name,continent);
        countryRepository.save(country);
        return country;
    }
}
