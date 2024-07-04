package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Deity;
import ru.surin.yatm.repository.DeityRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeityService {
    // TODO 007
    @Autowired
    DeityRepository deityRepository;

    public List<Deity> getDeityByName(String name) {
        return deityRepository.findByName(name);
    }

    public Optional<Deity> getDeityById(UUID id) {
        return deityRepository.findById(id);
    }
}
