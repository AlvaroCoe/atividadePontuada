package com.example.atividadePontuada1.service;

import com.example.atividadePontuada1.entity.FuncionarioEntity;
import com.example.atividadePontuada1.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    //LISTAR

    public List<FuncionarioEntity> ListarFuncionarios (){
        return repository.findAll();
    }

    //ADICIONAR

    public FuncionarioEntity AddFuncionario (FuncionarioEntity funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionário já cadastrado com esse Email!");
        }
        return repository.save(funcionario);
    }

    //ATUALIZAR

    public FuncionarioEntity AtualizarFuncionario (Long id, FuncionarioEntity funcionario) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado!");
        }

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    //EXCLUIR

    public void excluir (Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado!");
        }
        repository.deleteById(id);
    }
}



