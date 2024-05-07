package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Player;
import ru.surin.yatm.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayerByName(String name) {
        return playerRepository.findByName(name);
    }

    public Optional<Player> getPlayerById(UUID id) {
        return playerRepository.findById(id);
    }
}
