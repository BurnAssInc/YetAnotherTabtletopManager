package ru.surin.yatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.surin.yatm.model.Item;
import ru.surin.yatm.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {
    // TODO 007
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItemByName(String name) {
        return itemRepository.findByName(name);
    }

    public Optional<Item> getItemById(UUID id) {
        return itemRepository.findById(id);
    }
}
