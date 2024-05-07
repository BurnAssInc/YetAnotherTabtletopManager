package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.DnDClass;
import ru.surin.yatm.repository.DNDClassRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DNDClassService {
    @Autowired
    DNDClassRepository dndClassRepository;

    public List<DnDClass> getDNDClassByName (String name){
        return dndClassRepository.findByName(name);
    }
    public Optional<DnDClass> getDNDClassById (UUID id){
        return dndClassRepository.findById(id);
    }
}
