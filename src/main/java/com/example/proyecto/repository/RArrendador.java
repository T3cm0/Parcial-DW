package com.example.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.entity.Arrendador;

public interface RArrendador extends JpaRepository<Arrendador, Long> {
}
