package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.DndCharacterSkill;
import ru.surin.yatm.model.Skill;
import ru.surin.yatm.repository.SkillRepository;

import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;


    public Skill getSkillByName(String name) {
        return skillRepository.findByName(name);
    }

    public Skill getSkillById(UUID id) {
        return skillRepository.findSkillById(id);
    }

    public void changeSkillValue(Character character, Skill skill, int skillValue) {
        skillRepository.findByName(skill.getName());
    }

    public UUID getSkillIdFromEmbeddedClass(DndCharacterSkill dndCharacterSkill) {
        return dndCharacterSkill.getId().getSkillId();
    }
}
