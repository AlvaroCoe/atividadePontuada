package com.example.atividadePontuada1.service;

import com.example.atividadePontuada1.entity.ClienteEntity;
import com.example.atividadePontuada1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    //LISTAR

    public List<ClienteEntity> ListarCLientes (){
        return repository.findAll();
    }

    //ADICIONAR

    public ClienteEntity AddCliente (ClienteEntity cliente) {
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado com esse Email!");
        }
        return repository.save(cliente);
    }

    //ATUALIZAR

    public ClienteEntity AtualizarCliente (Long id, ClienteEntity cliente) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        cliente.setId(id);
        return repository.save(cliente);
    }

    //EXCLUIR

    public void excluir (Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        repository.deleteById(id);
    }
}


