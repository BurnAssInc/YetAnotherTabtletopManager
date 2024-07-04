package ru.surin.yatm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surin.yatm.model.Campaign;

import java.util.List;
import java.util.UUID;

@Repository

public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
    List<Campaign> findByName(String name);

}
