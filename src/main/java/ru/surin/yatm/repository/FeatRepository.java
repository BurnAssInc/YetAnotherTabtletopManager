package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surin.yatm.model.Feat;

import java.util.List;
import java.util.UUID;

@Repository
public interface FeatRepository extends JpaRepository<Feat, UUID> {
    List<Feat> findByName(String name);
}
