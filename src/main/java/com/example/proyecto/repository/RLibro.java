package com.example.proyecto.repository;

import com.example.proyecto.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RLibro extends JpaRepository<Libro, Long> {
}

