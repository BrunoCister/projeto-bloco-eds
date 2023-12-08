package com.projeto.pb.DTO;

import com.projeto.pb.entities.Item;

import java.util.UUID;

public record ItemResponseDTO(UUID id, String nome, Double valor, String imgUrl) {
    public ItemResponseDTO(Item item) {
        this(item.getId(), item.getNome(), item.getValor(), item.getImgUrl());
    }
}
