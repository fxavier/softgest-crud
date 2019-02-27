package com.xavier.softgest.service;

import com.xavier.softgest.model.Unity;
import com.xavier.softgest.repository.Unities;
import com.xavier.softgest.service.exception.UnityExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnityService {

    private Unities unities;

    public UnityService(@Autowired Unities unities) {
        this.unities = unities;
    }

    public Unity save(final Unity unity) {
        verifyIfExist(unity);
        return unities.save(unity);
    }

    public void deleteById(Long id) {
        unities.deleteById(id);
    }

    private void verifyIfExist(Unity unity) throws UnityExistException {
        Optional<Unity> foundUnity = unities.findByName(unity.getName());
        if (foundUnity.isPresent()) {
            throw new UnityExistException();
        }
    }

    private boolean isUpdatingToADifferentUnity(Unity unity, Optional<Unity> foundUnity) {
        return unity.exist() && !unity.equals(foundUnity.get());
    }

}
