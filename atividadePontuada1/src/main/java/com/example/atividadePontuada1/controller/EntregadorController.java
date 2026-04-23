package com.example.atividadePontuada1.controller;

import com.example.atividadePontuada1.entity.EntregadorEntity;
import com.example.atividadePontuada1.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping ("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    //LISTAR
    @GetMapping
    public List<EntregadorEntity> ListarEntregadores() {
        return service.ListarEntregadores();
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity<Map<String, Object>> AddEntregador (@RequestBody EntregadorEntity entregador) {
        service.AddEntregador(entregador);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Entregador chamado com sucesso."));
    }
    //ATUALIZAR
    @PutMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarEntregador(
            @PathVariable Long id,
            @RequestBody EntregadorEntity entregador) {
        service.AtualizarEntregador(id,entregador);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cadastro do entregador atualizado com sucesso."));
    }
    //DELETAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> TrocarEntregador (@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Entregador deletado."));
    }

}