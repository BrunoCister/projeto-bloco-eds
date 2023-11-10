package com.projeto.pb.DTO;

import com.projeto.pb.entities.Item;

public class ItemDTO {

    private Long id;
    private String nome;
    private double valor;
    private String imgUrl;
    
    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.valor = item.getValor();
        this.imgUrl = item.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
