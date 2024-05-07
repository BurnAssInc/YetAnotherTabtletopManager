package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surin.yatm.model.DnDClass;

import java.util.List;
import java.util.UUID;

@Repository
public interface DNDClassRepository extends JpaRepository<DnDClass, UUID> {
    List<DnDClass> findByName (String name);
}
