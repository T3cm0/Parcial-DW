package com.example.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto.entity.Arrendatario;

@Repository
public interface RArrendatario extends JpaRepository<Arrendatario, Long> {
    // Métodos de repositorio si es necesario
}

