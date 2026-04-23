package com.example.atividadePontuada1.service;

import com.example.atividadePontuada1.entity.ClienteEntity;
import com.example.atividadePontuada1.entity.EntregadorEntity;
import com.example.atividadePontuada1.repository.ClienteRepository;
import com.example.atividadePontuada1.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    //LISTAR

    public List<EntregadorEntity> ListarEntregadores (){
        return repository.findAll();
    }

    //ADICIONAR

    public EntregadorEntity AddEntregador (EntregadorEntity entregador) {
        if (repository.findByEmail(entregador.getEmail()).isPresent()) {
            throw new RuntimeException("Entregador já cadastrado com esse Email!");
        }
        return repository.save(entregador);
    }

    //ATUALIZAR

    public EntregadorEntity AtualizarEntregador (Long id, EntregadorEntity entregador) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador não encontrado!");
        }

        entregador.setId(id);
        return repository.save(entregador);
    }

    //EXCLUIR

    public void excluir (Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador não encontrado!");
        }
        repository.deleteById(id);
    }
}

