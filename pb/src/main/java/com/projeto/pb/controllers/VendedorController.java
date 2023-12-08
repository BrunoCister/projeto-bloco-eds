package com.projeto.pb.controllers;

import java.util.List;
import java.util.UUID;

import com.projeto.pb.DTO.*;
import com.projeto.pb.entities.Vendedor;
import com.projeto.pb.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    public VendedorRepository vendedorRepository;

    @GetMapping
    public List<VendedorResponseDTO> findAll() {
        List<VendedorResponseDTO> result = vendedorRepository.findAll().stream().map(VendedorResponseDTO::new).toList();
        return result;
    }

    @PostMapping
    public void save(@RequestBody VendedorRequestDTO data) {
        Vendedor vendedorData = new Vendedor(data);
        vendedorRepository.save(vendedorData);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        Vendedor result = vendedorRepository.findById(id).get();
        if (id.equals(result.getId())) {
            vendedorRepository.deleteById(id);
        }
    }
}
