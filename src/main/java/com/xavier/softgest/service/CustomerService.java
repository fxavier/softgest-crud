package com.xavier.softgest.service;

import com.xavier.softgest.model.Customer;
import com.xavier.softgest.repository.Customers;
import com.xavier.softgest.service.exception.CustomerExistsException;
import com.xavier.softgest.service.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private Customers customers;

    public CustomerService(@Autowired Customers customers) {
        this.customers = customers;
    }

    public Customer save(final Customer customer) {
        verifyIfExists(customer);
        return customers.save(customer);
    }

    public void deleteById(Long id) {
        verifyIfNotExists(id);
        customers.deleteById(id);
    }

    private void verifyIfNotExists(Long id) throws CustomerNotFoundException {
        Optional<Customer> foundCustomer = customers.findById(id);
        if (!foundCustomer.isPresent()) {
            throw new CustomerNotFoundException();
        }
    }

    private void verifyIfExists(Customer customer) throws CustomerExistsException {
        Optional<Customer> foundCustomer = customers.findByNameAndEmail(customer.getName(), customer.getEmail());
        if (foundCustomer.isPresent() && (customer.isNew() || isUpdatingToADifferentCustomer(customer, foundCustomer))) {
            throw new CustomerExistsException();
        }
    }

    private boolean isUpdatingToADifferentCustomer(Customer customer, Optional<Customer> foundCustomer) {
        return customer.exists() && !customer.equals(foundCustomer.get());
    }
}
