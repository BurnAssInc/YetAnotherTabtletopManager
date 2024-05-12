package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Character;
import ru.surin.yatm.model.Skill;
import ru.surin.yatm.repository.CharacterRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterService {
    // TODO 006
    // TODO 007
    @Autowired
    CharacterRepository characterRepository;


    public List<Character> getCharacterListByName(String name) {
        return characterRepository.findByNameContaining(name);
    }

    public Optional<Character> getCharacterById(UUID id) {
        return characterRepository.findById(id);
    }

    public List<Character> getCharacterListByStrength(int strength) {
        return characterRepository.findByStrength(strength);
    }
    public List<Character> getCharacterListByDexterity(int dexterity) {
        return characterRepository.findByDexterity(dexterity);
    }
    public List<Character> getCharacterListByConstitution(int constitution) {
        return characterRepository.findByConstitution(constitution);
    }
    public List<Character> getCharacterListByIntelligence(int intelligence) {
        return characterRepository.findByIntelligence(intelligence);
    }
    public List<Character> getCharacterListByWisdom(int wisdom) {
        return characterRepository.findByWisdom(wisdom);
    }
    public List<Character> getCharacterListByCharisma(int charisma) {
        return characterRepository.findByCharisma(charisma);
    }
    public List<Character> getCharacterListByCharacterHp(int characterHp) {
        return characterRepository.findByCharacterHp(characterHp);
    }
    public List<Character> getCharacterListByCharacterAc(int characterAc) {
        return characterRepository.findByCharacterAc(characterAc);
    }
    public List<Character> getCharacterListByCharacterSpeed(int characterSpeed) {
        return characterRepository.findByCharacterSpeed(characterSpeed);
    }
    public List<Character> getCharacterListBySkillId(UUID id){
        return null;// characterRepository.findCharacterListBySkillListId(id);
    }
    public  List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }
    public List<Character> getCharacterListBySkillName(String name){
        return null;//characterRepository.findCharacterListBySkillListName(name);
    }



}
