package com.example.atividadePontuada1.repository;

import com.example.atividadePontuada1.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Long> {
    Optional <ProdutoEntity> findByLote (String lote);
}
