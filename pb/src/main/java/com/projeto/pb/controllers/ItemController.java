package com.projeto.pb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.pb.DTO.ItemDTO;
import com.projeto.pb.services.ItemService;

@RestController
@RequestMapping(value = "/itens")
public class ItemController {

    @Autowired
    public ItemService itemService;

    @GetMapping
    public List<ItemDTO> findAll() {
        List<ItemDTO> result = itemService.findAll();
        return result;
    }
    
}
