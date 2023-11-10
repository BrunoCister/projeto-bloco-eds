package com.projeto.pb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.pb.DTO.VendedorDTO;
import com.projeto.pb.entities.Vendedor;
import com.projeto.pb.repositories.VendedorRepository;

@Service
public class VendedorService {
    
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<VendedorDTO> findAll() {
        List<Vendedor> result = vendedorRepository.findAll();
        List<VendedorDTO> dto = result.stream().map(v -> new VendedorDTO(v)).toList();
        return dto;
    }
}
