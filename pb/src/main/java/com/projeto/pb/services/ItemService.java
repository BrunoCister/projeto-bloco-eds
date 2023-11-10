package com.projeto.pb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.pb.DTO.ItemDTO;
import com.projeto.pb.entities.Item;
import com.projeto.pb.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> findAll() {
        List<Item> result = itemRepository.findAll();
        List<ItemDTO> dto = result.stream().map(i -> new ItemDTO(i)).toList();
        return dto;
    }
}
