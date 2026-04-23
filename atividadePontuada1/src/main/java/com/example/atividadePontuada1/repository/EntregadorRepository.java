package com.example.atividadePontuada1.repository;

import com.example.atividadePontuada1.entity.EntregadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntregadorRepository extends JpaRepository <EntregadorEntity, Long> {
    Optional <EntregadorEntity> findByEmail (String email);
}
