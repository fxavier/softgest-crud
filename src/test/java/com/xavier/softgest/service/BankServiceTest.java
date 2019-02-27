package com.xavier.softgest.service;

import com.xavier.softgest.model.Bank;
import com.xavier.softgest.repository.Banks;
import com.xavier.softgest.service.exception.BankExistsException;
import com.xavier.softgest.service.exception.CategoryExistsException;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BankService bankService;

    @Mock
    private Banks mockedBank;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bankService = new BankService(mockedBank);
    }


    @Test
    void should_denyToCreateBankThatExists() {
        Bank bankInDatabase = new Bank();
        bankInDatabase.setId(5L);
        bankInDatabase.setName("BCI");

        when(mockedBank.findByName("BCI")).thenReturn(Optional.of(bankInDatabase));

        Bank newBank = new Bank();
        newBank.setId(10L);
        newBank.setName("BCI");

        assertThrows(BankExistsException.class, () -> {

         bankService.save(newBank);
        });

    }

    @Test
    void should_saveNewBank() {
        Bank bank = new Bank();

        BDDMockito.given(mockedBank.save(any(Bank.class))).willReturn(bank);

        Bank savedBank = bankService.save(new Bank());

        BDDMockito.then(mockedBank).should().save(any(Bank.class));
        Assertions.assertThat(savedBank).isNotNull();
    }
}