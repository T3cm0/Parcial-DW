package com.example.proyecto.repository;

import com.example.proyecto.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSolicitud extends JpaRepository<Solicitud, Long> {
}

