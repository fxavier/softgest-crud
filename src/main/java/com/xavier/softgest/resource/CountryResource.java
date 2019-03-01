package com.xavier.softgest.resource;

import com.xavier.softgest.model.Country;
import com.xavier.softgest.repository.Countries;
import com.xavier.softgest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private Countries countries;

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> all() {
        return countries.findAll();
    }

    @GetMapping("/{id}")
    public Country findOne(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @PostMapping
    public Country create(@Valid @RequestBody Country country) {
        return countryService.save(country);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Country country) {
        country.setId(id);
        countryService.save(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryService.deleteById(id);
    }
}
