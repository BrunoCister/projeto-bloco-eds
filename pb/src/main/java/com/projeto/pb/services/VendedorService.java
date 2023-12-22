package com.projeto.pb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.pb.DTO.VendedorRequestDTO;
import com.projeto.pb.DTO.VendedorResponseDTO;
import com.projeto.pb.entities.Vendedor;
import com.projeto.pb.repositories.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    VendedorRepository vendedorRepository;

    public List<VendedorResponseDTO> findAll() {
        List<VendedorResponseDTO> result = vendedorRepository.findAll().stream().map(VendedorResponseDTO::new).toList();
        return result;
    }

    public Optional<VendedorResponseDTO> findById(UUID id) {
        Optional<VendedorResponseDTO> result = vendedorRepository.findById(id).map(VendedorResponseDTO::new);
        return result;
    }

    public void save(VendedorRequestDTO vendedorRequestDTO) {
        Vendedor vendedor = new Vendedor(vendedorRequestDTO);
        vendedorRepository.save(vendedor);
    }
    
    public VendedorResponseDTO patch(UUID id, VendedorRequestDTO vendedorRequestDTO) {
        Vendedor result = vendedorRepository.findById(id).get();
        BeanUtils.copyProperties(vendedorRequestDTO, result, "id");
        Vendedor updatedVendedor = vendedorRepository.save(result);
        VendedorResponseDTO responseDTO = new VendedorResponseDTO(updatedVendedor);
        return responseDTO;
    }
        

    public void delete(UUID id) {
        Vendedor result = vendedorRepository.findById(id).get();
        if (id.equals(result.getId())) {
            vendedorRepository.delete(result);
        }
    }
}
