package com.projeto.pb.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.projeto.pb.DTO.ItemRequestDTO;
import com.projeto.pb.DTO.ItemResponseDTO;
import com.projeto.pb.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/itens")
public class ItemController {

    @Autowired
    public ItemService itemService;

    @GetMapping
    public ResponseEntity findAll() {
        try {
            List<ItemResponseDTO> result = itemService.findAll();
            return ResponseEntity.ok(result);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable UUID id) {
        try {
            Optional<ItemResponseDTO> result = itemService.findById(id);
            return ResponseEntity.ok(result);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ItemRequestDTO itemRequestDTO) {
        try {
            itemService.save(itemRequestDTO);
            return ResponseEntity.ok().build();
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ItemResponseDTO> patch(@PathVariable UUID id, @RequestBody ItemRequestDTO itemRequestDTO) {
        try {
            Optional<ItemResponseDTO> optionalItem = itemService.findById(id);
            if (optionalItem.isPresent()) {
                ItemResponseDTO itemResponseDTO = itemService.patch(id, itemRequestDTO);
                return ResponseEntity.ok(itemResponseDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            Optional<ItemResponseDTO> optionalItem = itemService.findById(id);
            if (optionalItem.isPresent()) {
                itemService.delete(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
