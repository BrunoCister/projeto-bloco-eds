package com.projeto.pb.DTO;

import com.projeto.pb.entities.Vendedor;

import java.util.UUID;

public record VendedorResponseDTO(UUID id, String nome, String email) {
    public VendedorResponseDTO(Vendedor vendedor) {
        this(vendedor.getId(), vendedor.getNome(), vendedor.getEmail());
    }
}
