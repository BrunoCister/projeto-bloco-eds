package com.projeto.pb.DTO;

import java.util.UUID;

import com.projeto.pb.entities.Item;

public class ItemDTO {

    private UUID id;
    private String nome;
    private Double valor;
    private String imgUrl;
    
    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.valor = item.getValor();
        this.imgUrl = item.getImgUrl();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
