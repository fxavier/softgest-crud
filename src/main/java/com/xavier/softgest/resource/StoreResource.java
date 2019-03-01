package com.xavier.softgest.resource;

import com.xavier.softgest.model.Store;
import com.xavier.softgest.repository.Stores;
import com.xavier.softgest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreResource {

    @Autowired
    private Stores stores;

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> all() {
        return stores.findAll();
    }

    @GetMapping("/{id}")
    public Store findOne(@PathVariable Long id) {
        return storeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store create(@Valid @RequestBody Store store) {
        return storeService.save(store);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Store store) {
        store.setId(id);
        storeService.save(store);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        storeService.deleteById(id);
    }
}
