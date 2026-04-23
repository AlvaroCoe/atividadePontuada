package com.example.atividadePontuada1.service;

import com.example.atividadePontuada1.entity.ProdutoEntity;
import com.example.atividadePontuada1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    //LISTAR

    public List<ProdutoEntity> ListarProdutos (){
        return repository.findAll();
    }

    //ADICIONAR

    public ProdutoEntity AddProduto (ProdutoEntity produto) {
        if (repository.findByLote(produto.getLote()).isPresent()) {
            throw new RuntimeException("Produto já cadastrado com esse Lote!");
        }
        return repository.save(produto);
    }

    //ATUALIZAR

    public ProdutoEntity AtualizarProduto (Long id, ProdutoEntity produto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado!");
        }

        produto.setId(id);
        return repository.save(produto);
    }

    //EXCLUIR

    public void excluir (Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        repository.deleteById(id);
    }
}



