package com.projeto.pb.controllers;

import java.util.List;
import java.util.UUID;

import com.projeto.pb.DTO.ItemRequestDTO;
import com.projeto.pb.DTO.ItemResponseDTO;
import com.projeto.pb.entities.Item;
import com.projeto.pb.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/itens")
public class ItemController {

    @Autowired
    public ItemRepository itemRepository;

    @GetMapping
    public List<ItemResponseDTO> findAll() {
        List<ItemResponseDTO> result = itemRepository.findAll().stream().map(ItemResponseDTO::new).toList();
        return result;
    }

    @PostMapping
    public void save(@RequestBody ItemRequestDTO data) {
        Item itemData = new Item(data);
        itemRepository.save(itemData);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        Item result = itemRepository.findById(id).get();
        if (id.equals(result.getId())) {
            itemRepository.deleteById(id);
        }
    }
}
