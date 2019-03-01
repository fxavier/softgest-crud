package com.xavier.softgest.resource;

import com.xavier.softgest.model.Unity;
import com.xavier.softgest.repository.Unities;
import com.xavier.softgest.service.UnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/unities")
public class UnityResource {

    @Autowired
    private Unities unities;

    @Autowired
    private UnityService unityService;

    @GetMapping
    public List<Unity> all() {
        return unities.findAll();
    }

    @GetMapping("/{id}")
    public Unity findOne(@PathVariable Long id) {
        return unityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Unity create(@Valid @RequestBody Unity unity) {
        return unityService.save(unity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Unity unity) {
        unity.setId(id);
        unityService.save(unity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        unityService.deleteById(id);
    }
}
