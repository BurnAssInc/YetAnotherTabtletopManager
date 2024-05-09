package ru.surin.yatm.controller;
// TODO 001: Неоптимизированные импорты (ctrl+alt+o (оу))
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.surin.yatm.model.Character;
import ru.surin.yatm.model.Skill;
import ru.surin.yatm.repository.CharacterRepository;
import ru.surin.yatm.repository.SkillRepository;
import ru.surin.yatm.service.CharacterService;
import ru.surin.yatm.service.SkillService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    // TODO 002: Для всего класса. Некорректное представление коментария (/**...*//)
    // TODO 008: Для всего класса. Превыщение длинны строки блее чем 120 символов
    @GetMapping("/strength")//Сортировка по параметру strength
    public ResponseEntity<List<Character>> getCharacterListByStrength(@RequestParam(value = "str", required = false) int strength) {
        List<Character> characterList = new ArrayList<>();
        characterService.getCharacterListByStrength(strength).forEach(characterList::add);
        if (characterList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(characterList, HttpStatus.OK);
        }


    }

    // TODO 003: Для всего класса. Привести к единому виду все методы с использованием RequestParam
    @GetMapping("/{characterName}") //Получение списка Character по имени
    public ResponseEntity<List<Character>> getCharacterListByName(@PathVariable(value = "characterName", required = false) String name) {
        List<Character> characterList = new ArrayList<Character>();
        if (name == null) {
            characterService.getAllCharacters();
        } else {
            characterList.addAll(characterService.getCharacterListByName(name));
        }
        if (characterList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(characterList, HttpStatus.OK);
        }
    }

    @GetMapping("/skills/{skillId}") //получение списка Character по skillId
    public ResponseEntity<List<Character>> getAllCharactersBySkillId(@PathVariable(value = "skillId") UUID id) {
        if (!skillRepository.existsById(id)) {
            throw new OpenApiResourceNotFoundException("Skill not found " + id);
        }
        List<Character> characterList = characterService.getCharacterListBySkillId(id);
        return new ResponseEntity<>(characterList, HttpStatus.OK);
    }

    @GetMapping("/skills/{skillName}") //получение списка Character по skillName
    public ResponseEntity<List<Character>> getAllCharactersBySkillName(@PathVariable(value = "skillName") String name) {
        if (!skillRepository.findByName(name).isEmpty()) {
            throw new OpenApiResourceNotFoundException("Skill not found " + name);
        }
        List<Character> characterList = characterService.getCharacterListBySkillName(name);
        return new ResponseEntity<>(characterList, HttpStatus.OK);
    }

    // TODO 004: Для всего класса. Выбрасываемое исключение никак не обрабатывается.
    //  Возможно следует использовать .findFirst().orElse(null);,
    //  а далее при значении character == null (А вообще более красивый вариант: Objects.nonNull(character)) возвращать httpStatus.NO_CONTENT.
    @PostMapping("/addSkill")
    //добавление к Character skill по его имени (это скорее проверочный метод, т.к. возвращать значиние не нужно
    public ResponseEntity<Character> addSkillToCharacter(@RequestParam(value = "skillname") String skillName, @RequestParam(value = "chaname") String characterName) {
        Skill _skill = skillService.getSkillByName(skillName).stream().findFirst()
                .orElseThrow();
        Character character = characterService.getCharacterListByName(characterName).stream().findFirst()
                .orElseThrow();
        character.addSkill(_skill);
        characterRepository.save(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/removeSkill", method = {RequestMethod.DELETE, RequestMethod.GET})
    // удаление skill у Character
    public void deleteSkillFromCharacter(@RequestParam(value = "skillname") String skillName, @RequestParam(value = "chaname") String characterName) {
        Skill skill = skillService.getSkillByName(skillName).stream().findFirst().orElseThrow();
        Character character = characterService.getCharacterListByName(characterName).stream().findFirst().orElseThrow();
        character.deleteSkill(skill);
        characterRepository.save(character);
    }
}
