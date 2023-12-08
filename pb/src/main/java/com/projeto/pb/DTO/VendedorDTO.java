package com.projeto.pb.DTO;

import java.util.UUID;

import com.projeto.pb.entities.Vendedor;

public class VendedorDTO {

    private UUID id;
    private String nome;
    private String email;
    
    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.email = vendedor.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
