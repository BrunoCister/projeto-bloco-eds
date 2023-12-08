package com.projeto.pb.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.pb.entities.Item;

public interface ItemRepository extends JpaRepository<Item, UUID> {
    
}
