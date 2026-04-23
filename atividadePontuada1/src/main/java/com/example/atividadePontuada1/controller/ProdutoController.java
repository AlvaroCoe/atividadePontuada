package com.example.atividadePontuada1.controller;

import com.example.atividadePontuada1.entity.ProdutoEntity;
import com.example.atividadePontuada1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping ("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    //LISTAR
    @GetMapping
    public List<ProdutoEntity> ListarProdutos() {
        return service.ListarProdutos();
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity<Map<String, Object>> AddProdutos (@RequestBody ProdutoEntity produto) {
        service.AddProduto(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Produto adicionado com sucesso."));
    }
    //ATUALIZAR
    @PutMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarProduto(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto) {
        service.AtualizarProduto(id,produto);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Produto atualizado com sucesso."));
    }
    //DELETAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> ExcluirProduto (@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Produto excluido do catálogo."));
    }

}