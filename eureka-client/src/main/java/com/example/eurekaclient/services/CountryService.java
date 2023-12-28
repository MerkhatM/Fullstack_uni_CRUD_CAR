package com.example.eurekaclient.services;

import com.example.eurekaclient.models.Country;
import com.example.eurekaclient.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll().stream().sorted(Comparator.comparing(Country::getId)).toList();
    }

    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void editCountry(Country newCountry,Long id) {
        Country country=countryRepository.findById(id).orElse(null);
        country.setId(newCountry.getId());
        country.setName(newCountry.getName());
        country.setShortName(newCountry.getShortName());

        countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }


}
