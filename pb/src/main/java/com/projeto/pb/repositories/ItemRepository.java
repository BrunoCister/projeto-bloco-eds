package com.projeto.pb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.pb.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
