package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surin.yatm.model.Race;

import java.util.List;
import java.util.UUID;
@Repository
public interface RaceRepository extends JpaRepository<Race, UUID> {
    List<Race> findByName (String name);
}
