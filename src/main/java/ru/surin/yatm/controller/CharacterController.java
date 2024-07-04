package ru.surin.yatm.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.surin.yatm.model.Character;
import ru.surin.yatm.model.Skill;
import ru.surin.yatm.repository.CharacterRepository;
import ru.surin.yatm.repository.DndCharacterSkillRepository;
import ru.surin.yatm.repository.SkillRepository;
import ru.surin.yatm.service.CharacterService;
import ru.surin.yatm.service.SkillService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/character")
public class CharacterController {
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

    /**
     * Сортировка по параметру strength
     *
     * @param strength
     * @return
     */
    @GetMapping("/strength")
    public ResponseEntity<List<Character>> getCharacterListByStrength(@RequestParam(value = "str",
            required = false) int strength) {

        List<Character> characterList = new ArrayList<>();
        characterService.getCharacterListByStrength(strength).forEach(characterList::add);
        if (characterList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(characterList, HttpStatus.OK);
        }
    }

    /**
     * Получение списка Character по имени
     *
     * @param name
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Character>> getCharacterListByName(@RequestParam(value = "characterName",
            required = false) String name) {
        List<Character> characterList = new ArrayList<>();
        if (StringUtils.isEmpty(name)) {
            characterList.addAll(characterService.getAllCharacters());
        } else {
            characterList.addAll(characterService.getCharacterListByName(name));
        }
        if (characterList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(characterList, HttpStatus.OK);
        }
    }

    /**
     * получение списка Character по skillId
     *
     * @param id
     * @return
     */
    @GetMapping("/skillId")
    public ResponseEntity<List<Character>> getAllCharactersBySkillId(@RequestParam(value = "skillId") UUID id) {
        if (!skillRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<Character> characterList = skillService.getSkillById(id).getDndCharacterSkillSet().stream()
                    .map(dndCharacterSkill -> dndCharacterSkill.getCharacter()).collect(Collectors.toUnmodifiableList());
            return new ResponseEntity<>(characterList, HttpStatus.OK);
        }
    }

    /**
     * получение списка Character по skillName
     *
     * @param name
     * @return
     */
    @GetMapping("/skillName")
    public ResponseEntity<List<Character>> getAllCharactersBySkillName(@RequestParam(value = "skillName") String name) {
        if (skillService.getSkillByName(name).getDndCharacterSkillSet().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            //из скила получаем dndCharacterskillset, из него получаем всех чарактеров по скилу
            List<Character> characterList = skillService.getSkillByName(name).getDndCharacterSkillSet()
                    .stream()
                    .map(dndCharacterSkill -> dndCharacterSkill.getCharacter())
                    .collect(Collectors.toUnmodifiableList());

            return new ResponseEntity<>(characterList, HttpStatus.OK);
        }
    }

    /**
     * добавление к Character skill по его имени (это скорее проверочный метод, т.к. возвращать значиние не нужно
     *
     * @param skillName
     * @param characterName
     * @param skillRank
     * @return
     */
    @PostMapping("/addSkill")
    public ResponseEntity<Character> addSkillToCharacter(@RequestParam(value = "skillName") String skillName,
                                                         @RequestParam(value = "chaName") String characterName,
                                                         @RequestParam(value = "skillRank") int skillRank) {
        Skill skill = skillService.getSkillByName(skillName);
        Character character = characterService.getCharacterListByName(characterName).stream().findFirst()
                .orElse(null);
        if (Objects.isNull(character) || Objects.isNull(skill)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            character.addSkill(skill, skillRank);
            characterRepository.save(character);
            return new ResponseEntity<>(character, HttpStatus.CREATED);
        }
    }

    /**
     * удаление skill у Character
     *
     * @param skillName
     * @param characterName
     */
    //TODO Вынести логику в сервис
    @RequestMapping(value = "/removeSkill", method = {RequestMethod.DELETE})
    public void deleteSkillFromCharacter(@RequestParam(value = "skillname") String skillName,
                                         @RequestParam(value = "chaname") String characterName) {
        Skill skill = skillService.getSkillByName(skillName);
        Character character = characterService.getCharacterListByName(characterName).stream().findFirst().orElse(null);
        if (Objects.isNull(character) || Objects.isNull(skill)) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            character.deleteSkill(skill);
            //TODO не удаляет из базы данных
            characterRepository.saveAndFlush(character);

            new ResponseEntity<>(character, HttpStatus.OK);
        }

    }
}
