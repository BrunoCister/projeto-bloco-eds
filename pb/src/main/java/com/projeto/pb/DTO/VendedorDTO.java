package com.projeto.pb.DTO;

import com.projeto.pb.entities.Vendedor;

public class VendedorDTO {

    private Long id;
    private String nome;
    private String email;
    
    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.email = vendedor.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
