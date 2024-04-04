package com.example.proyecto.repository;

import com.example.proyecto.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPago extends JpaRepository<Pago, Long> {
}


