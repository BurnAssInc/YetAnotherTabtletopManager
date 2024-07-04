package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surin.yatm.model.Character;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {
    List<Character> findByNameContaining(String name);

    List<Character> findByStrength(int strength);

    List<Character> findByDexterity(int dexterity);

    List<Character> findByConstitution(int constitution);

    List<Character> findByIntelligence(int intelligence);

    List<Character> findByWisdom(int wisdom);

    List<Character> findByCharisma(int charisma);

    List<Character> findByCharacterHp(int characterHp);

    List<Character> findByCharacterAc(int characterAc);

    List<Character> findByCharacterSpeed(int characterSpeed);
    // TODO 002
    // TODO 005
    // TODO 006
    List<Character> findByPlayerId(UUID id);

    //List<Character> findCharacterListByListId(UUID id);//поиск списка персонажей по id скила
    //List<Character> findCharacterListBySkillListName(String name);//поиск списка персонажей по имени скила


}