package com.example.atividadePontuada1.controller;

import com.example.atividadePontuada1.entity.ClienteEntity;
import com.example.atividadePontuada1.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping ("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    //LISTAR
    @GetMapping
    public List<ClienteEntity> ListarClientes() {
        return service.ListarCLientes();
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity<Map<String, Object>> AddCliente (@RequestBody ClienteEntity cliente) {
        service.AddCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente cadastrado com sucesso."));
    }
    //ATUALIZAR
    @PutMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarCliente(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente) {
        service.AtualizarCliente(id,cliente);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cadastro do cliente atualizado com sucesso."));
    }
    //DELETAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> DeletarCliente (@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente excluído."));
    }

}