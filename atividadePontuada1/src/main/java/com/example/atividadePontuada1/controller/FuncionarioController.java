package com.example.atividadePontuada1.controller;

import com.example.atividadePontuada1.entity.FuncionarioEntity;
import com.example.atividadePontuada1.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping ("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    //LISTAR
    @GetMapping
    public List<FuncionarioEntity> ListarFuncionarios() {
        return service.ListarFuncionarios();
    }

    //ADICIONAR
    @PostMapping
    public ResponseEntity<Map<String, Object>> AddFuncionario (@RequestBody FuncionarioEntity funcionario) {
        service.AddFuncionario(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Funcionário admitido com sucesso."));
    }
    //ATUALIZAR
    @PutMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarFuncionario(
            @PathVariable Long id,
            @RequestBody FuncionarioEntity funcionario) {
        service.AtualizarFuncionario(id,funcionario);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cadastro do funcionário atualizado com sucesso."));
    }
    //DELETAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> DemitirFuncionario (@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Funcionario desligado da empresa.."));
    }

}