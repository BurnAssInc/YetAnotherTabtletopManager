package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Race;
import ru.surin.yatm.repository.RaceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RaceService {
    @Autowired
    RaceRepository raceRepository;
    public List<Race> getRaceByName (String name){
        return raceRepository.findByName(name);
    }
    public Optional<Race> getRaceById (UUID id){
        return raceRepository.findById(id);
    }
}
