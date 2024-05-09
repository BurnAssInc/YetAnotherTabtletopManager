package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Campaign;
import ru.surin.yatm.repository.CampaignRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampaignService {
    //    TODO 007: Все классы сервисов репозиториев следует вынести в отдельный пакет (типа repositoryServices)
    @Autowired
    CampaignRepository campaignRepository;

    public List<Campaign> getCampaignListByName(String name) {
        return campaignRepository.findByName(name);
    }

    public Optional<Campaign> getCampaignById(UUID id) {
        return campaignRepository.findById(id);
    }
}
