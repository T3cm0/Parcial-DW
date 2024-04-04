package com.example.proyecto.repository;

import com.example.proyecto.entity.Propiedades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPropiedades extends JpaRepository<Propiedades, Long> {
}
