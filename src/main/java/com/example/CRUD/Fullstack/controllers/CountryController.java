package com.example.CRUD.Fullstack.controllers;

import com.example.CRUD.Fullstack.models.Country;
import com.example.CRUD.Fullstack.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http:://localhost:3000")
@RequestMapping("/companies")
public class CountryController {
    @Autowired
    private CountryService countryService;


    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }


    @GetMapping("{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.getCountry(id);
    }

    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @PutMapping("{id}")
    public void editCountry(@RequestBody Country country,@PathVariable Long id) {
        countryService.editCountry(country,id);
    }

    @DeleteMapping("{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }

}
