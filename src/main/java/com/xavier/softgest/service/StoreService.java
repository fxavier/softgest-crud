package com.xavier.softgest.service;

import com.xavier.softgest.model.Store;
import com.xavier.softgest.repository.Stores;
import com.xavier.softgest.service.exception.StoreExistException;
import com.xavier.softgest.service.exception.StoreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    private Stores stores;

    public StoreService(@Autowired Stores stores) {
        this.stores = stores;
    }

    public Store save(final Store store) {
        verifyIfExists(store);
        return stores.save(store);
    }

    public void deleteById(Long id) {
        Optional<Store> foundStore = stores.findById(id);
        if (!foundStore.isPresent()) {
            throw new StoreNotFoundException();
        }
        stores.deleteById(id);
    }

    private void verifyIfExists(Store store) throws StoreExistException {
        Optional<Store> foundStore = stores.findByName(store.getName());
        if (foundStore.isPresent() && (store.isNew() || isUpdatingToADifferentStore(store, foundStore))) {
            throw new StoreExistException();
        }
    }

    private boolean isUpdatingToADifferentStore(Store store, Optional<Store> foundStore) {
        return store.exists() && !store.equals(foundStore.get());
    }
}
