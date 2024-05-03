package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.surin.yatm.model.Character;

import java.util.List;
import java.util.UUID;

public interface CharacterRepository extends JpaRepository<Character, UUID> {
    List<Character> findByCharacterNameContaining(String name);
}
