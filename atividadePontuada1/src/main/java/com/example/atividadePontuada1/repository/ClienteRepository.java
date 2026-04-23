package com.example.atividadePontuada1.repository;

import com.example.atividadePontuada1.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository <ClienteEntity, Long> {
    Optional <ClienteEntity> findByEmail (String email);
}
