package com.xavier.softgest.service;

import com.xavier.softgest.model.Currency;
import com.xavier.softgest.repository.Currencies;
import com.xavier.softgest.service.exception.CurrencyExistsException;
import com.xavier.softgest.service.exception.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    private Currencies currencies;

    public CurrencyService(@Autowired Currencies currencies) {
        this.currencies = currencies;
    }

    public Currency save(final Currency currency) {
        verifyIfExists(currency);
        return currencies.save(currency);
    }

    public void deleteById(Long id) {
        verifyIfCurrencyNotExists(id);
    }

    private void verifyIfExists(Currency currency) throws CurrencyExistsException {
        Optional<Currency> foundCurrency = currencies.findByNameAndCode(currency.getName(), currency.getCode());
        if (foundCurrency.isPresent() && (currency.isNew() || isUpdatingToADifferentCurrency(currency, foundCurrency))) {
            throw new CurrencyExistsException();
        }
    }

    private boolean isUpdatingToADifferentCurrency(Currency currency, Optional<Currency> foundCurrency) {
        return currency.exists() && !currency.equals(foundCurrency.get());
    }

    private void verifyIfCurrencyNotExists(Long id) throws CurrencyNotFoundException {
        Optional<Currency> foundCurrency = currencies.findById(id);
        if (!foundCurrency.isPresent()) {
            throw new CurrencyNotFoundException();
        }
    }
}
