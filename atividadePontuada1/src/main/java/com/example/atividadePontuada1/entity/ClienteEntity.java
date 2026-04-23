package com.example.atividadePontuada1.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "tab_clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String formaPagamento;
    private String endereco;

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String name, String email, String telefone, String formaPagamento, String endereco) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.formaPagamento = formaPagamento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
