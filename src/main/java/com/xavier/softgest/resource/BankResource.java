package com.xavier.softgest.resource;

import com.xavier.softgest.model.Bank;
import com.xavier.softgest.repository.Banks;
import com.xavier.softgest.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banks")
public class BankResource {

    @Autowired
    private Banks banks;

    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> all() {
        return banks.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        Optional<Bank> foundBank = banks.findById(id);
        return foundBank.isPresent() ? ResponseEntity.ok(foundBank.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@Valid @RequestBody Bank bank) {
        return bankService.save(bank);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Bank bank) {
        bank.setId(id);
        bankService.save(bank);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bankService.delete(id);
    }
}
