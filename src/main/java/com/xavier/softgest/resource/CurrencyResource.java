package com.xavier.softgest.resource;

import com.xavier.softgest.model.Currency;
import com.xavier.softgest.repository.Currencies;
import com.xavier.softgest.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyResource {

    @Autowired
    private Currencies currencies;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> all() {
        return currencies.findAll();
    }

    @GetMapping("/{id}")
    public Currency findOne(@PathVariable Long id) {
        return currencyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Currency create(@Valid @RequestBody Currency currency) {
        return currencyService.save(currency);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Currency currency) {
        currency.setId(id);
        currencyService.save(currency);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        currencyService.deleteById(id);
    }
}
