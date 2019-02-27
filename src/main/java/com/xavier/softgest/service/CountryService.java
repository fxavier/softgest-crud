package com.xavier.softgest.service;

import com.xavier.softgest.model.Country;
import com.xavier.softgest.repository.Countries;
import com.xavier.softgest.service.exception.CountryExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private Countries countries;

    public CountryService(@Autowired Countries countries) {
        this.countries = countries;
    }

    public Country save(final Country country) {
        verifyIfCountryExists(country);
        return countries.save(country);
    }

    private void verifyIfCountryExists(Country country) throws CountryExistException {
        Optional<Country> foundCountry = countries.findByName(country.getName());
        if (foundCountry.isPresent()) {
            throw new CountryExistException();
        }
    }
}
