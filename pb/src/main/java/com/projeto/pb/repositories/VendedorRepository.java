package com.projeto.pb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.pb.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    
}
