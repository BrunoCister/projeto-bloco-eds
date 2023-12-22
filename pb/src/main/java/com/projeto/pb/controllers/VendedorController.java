package com.projeto.pb.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.projeto.pb.DTO.*;
import com.projeto.pb.services.VendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    public VendedorService vendedorService;

    @GetMapping
    public ResponseEntity findAll() {
        try {
            List<VendedorResponseDTO> result = vendedorService.findAll();
            return ResponseEntity.ok(result);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable UUID id) {
        try {
            Optional<VendedorResponseDTO> result = vendedorService.findById(id);
            return ResponseEntity.ok(result);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody VendedorRequestDTO vendedorRequestDTO) {
        try {
            vendedorService.save(vendedorRequestDTO);
            return ResponseEntity.ok().build();
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<VendedorResponseDTO> patch(@PathVariable UUID id, @RequestBody VendedorRequestDTO vendedorRequestDTO) {
        try {
            Optional<VendedorResponseDTO> optionalVendedor = vendedorService.findById(id);
            if (optionalVendedor.isPresent()) {
                VendedorResponseDTO vendedorResponseDTO = vendedorService.patch(id, vendedorRequestDTO);
                return ResponseEntity.ok(vendedorResponseDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            Optional<VendedorResponseDTO> optionalVendedor = vendedorService.findById(id);
            if (optionalVendedor.isPresent()) {
                vendedorService.delete(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
