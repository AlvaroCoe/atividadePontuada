package com.example.atividadePontuada1.repository;

import com.example.atividadePontuada1.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FuncionarioRepository extends JpaRepository <FuncionarioEntity, Long> {
    Optional <FuncionarioEntity> findByEmail (String email);
}
