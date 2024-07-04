package ru.surin.yatm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.surin.yatm.model.Skill;
import ru.surin.yatm.repository.CharacterRepository;
import ru.surin.yatm.repository.DndCharacterSkillRepository;
import ru.surin.yatm.repository.SkillRepository;
import ru.surin.yatm.service.CharacterService;
import ru.surin.yatm.service.SkillService;

import java.util.UUID;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private CharacterService characterService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private DndCharacterSkillRepository dndCharacterSkillRepository;

    @GetMapping("/byId")
    public ResponseEntity<Skill> getSkillNameById(@RequestParam(value = "id") UUID id) {
        Skill skill = skillService.getSkillById(id);
        if (skill == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(skill, HttpStatus.OK);
        }


    }
}
