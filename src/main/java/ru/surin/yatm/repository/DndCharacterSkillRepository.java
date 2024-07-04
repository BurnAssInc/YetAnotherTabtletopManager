package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.surin.yatm.model.DndCharacterSkill;
import java.util.UUID;

public interface DndCharacterSkillRepository extends JpaRepository<DndCharacterSkill, UUID> {


}
