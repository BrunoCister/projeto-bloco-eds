package com.projeto.pb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.pb.DTO.VendedorDTO;
import com.projeto.pb.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    public VendedorService vendedorService;

    @GetMapping
    public List<VendedorDTO> findAll() {
        List<VendedorDTO> result = vendedorService.findAll();
        return result;
    }
}
