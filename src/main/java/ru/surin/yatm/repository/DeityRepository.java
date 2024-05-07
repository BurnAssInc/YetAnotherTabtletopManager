package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surin.yatm.model.Deity;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeityRepository extends JpaRepository<Deity, UUID> {

    List<Deity> findByName (String name);
}
