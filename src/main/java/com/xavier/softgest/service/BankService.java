package com.xavier.softgest.service;

import com.xavier.softgest.model.Bank;
import com.xavier.softgest.repository.Banks;
import com.xavier.softgest.service.exception.BankExistsException;
import com.xavier.softgest.service.exception.BankNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    private Banks banks;

    public BankService(@Autowired Banks banks) {
        this.banks = banks;
    }

    public Bank save(final Bank bank) {
        verifyIfBankExists(bank);
        return banks.save(bank);
    }

    public void delete(Long id) {
        verifyIfNotExists(id);
        banks.deleteById(id);
    }

    private void verifyIfBankExists(final Bank bank) throws BankExistsException {
        Optional<Bank> foundBank = banks.findByName(bank.getName());
        if (foundBank.isPresent() && (bank.isNew() || isUpdatingToADifferentBank(bank, foundBank))) {
            throw new BankExistsException();
        }
    }

    private boolean isUpdatingToADifferentBank(Bank bank, Optional<Bank> foundBank) {
        return bank.exists() && !bank.equals(foundBank.get());
    }

    private void verifyIfNotExists(Long id) throws BankNotFoundException {
        Optional<Bank> foundBank = banks.findById(id);
        if (!foundBank.isPresent()) {
            throw new BankNotFoundException();
        }
    }
}
