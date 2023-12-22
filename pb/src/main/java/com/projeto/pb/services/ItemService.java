package com.projeto.pb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.pb.DTO.ItemRequestDTO;
import com.projeto.pb.DTO.ItemResponseDTO;
import com.projeto.pb.entities.Item;
import com.projeto.pb.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<ItemResponseDTO> findAll() {
        List<ItemResponseDTO> result = itemRepository.findAll().stream().map(ItemResponseDTO::new).toList();
        return result;
    }

    public Optional<ItemResponseDTO> findById(UUID id) {
        Optional<ItemResponseDTO> result = itemRepository.findById(id).map(ItemResponseDTO::new);
        return result;
    }

    public void save(ItemRequestDTO itemRequestDTO) {
        Item item = new Item(itemRequestDTO);
        itemRepository.save(item);
    }
    
    public ItemResponseDTO patch(UUID id, ItemRequestDTO itemRequestDTO) {
        Item result = itemRepository.findById(id).get();
        BeanUtils.copyProperties(itemRequestDTO, result, "id");
        Item updatedItem = itemRepository.save(result);
        ItemResponseDTO responseDTO = new ItemResponseDTO(updatedItem);
        return responseDTO;
    }
        

    public void delete(UUID id) {
        Item result = itemRepository.findById(id).get();
        if (id.equals(result.getId())) {
            itemRepository.delete(result);
        }
    } 
}
