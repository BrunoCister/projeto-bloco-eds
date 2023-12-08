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
    private String imgUrl;

    public Item() {

    }

    public Item(UUID id, String nome, Double valor, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.imgUrl = imgUrl;
    }

    public Item(ItemRequestDTO data) {
        this.nome = data.nome();
        this.valor = data.valor();
        this.imgUrl = data.imgUrl();
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
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }  
    
    
}
