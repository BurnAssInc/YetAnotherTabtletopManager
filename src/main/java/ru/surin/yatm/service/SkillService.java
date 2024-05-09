package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Skill;
import ru.surin.yatm.repository.SkillRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {
    // TODO 007
    @Autowired
    SkillRepository skillRepository;

    public List <Skill> getSkillByName(String name){
        return skillRepository.findByName(name);
    }
    public Optional<Skill> getSkillById (UUID id){
        return skillRepository.findById(id);
    }
}
