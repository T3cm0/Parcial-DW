package com.example.proyecto.repository;

import com.example.proyecto.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RToken extends JpaRepository<Token, Long> {
}
