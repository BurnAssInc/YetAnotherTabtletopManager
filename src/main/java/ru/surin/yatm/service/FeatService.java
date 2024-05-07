package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Feat;
import ru.surin.yatm.repository.FeatRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeatService {
    @Autowired
    FeatRepository featRepository;

    public List<Feat> getFeatByName(String name) {
        return featRepository.findByName(name);
    }

    public Optional<Feat> getFeatById(UUID id) {
        return featRepository.findById(id);
    }
}
