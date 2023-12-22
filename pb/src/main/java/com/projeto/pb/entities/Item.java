package com.projeto.pb.entities;

import java.util.UUID;

import com.projeto.pb.DTO.ItemRequestDTO;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;
    private String nome;
    private Double valor;
    private String img_url;

    public Item() {

    }

    public Item(UUID id, String nome, Double valor, String img_url) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.img_url = img_url;
    }

    public Item(ItemRequestDTO data) {
        this.nome = data.nome();
        this.valor = data.valor();
        this.img_url = data.img_url();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }  
    
    
}
