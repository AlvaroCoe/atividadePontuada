package com.example.atividadePontuada1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @RestController
    public class BemVindo {
        @GetMapping("/")
        public String mensagem() {
            return "Seja bem vindo";
        }

        @GetMapping("/dev")
        public String nomeDev() {
            return "Meu nome é Alvaro Coelho";
        }

        @GetMapping("/atividade")
        public String atividade() {
            return "Essa é minha atividade pontuada na matéria de DS";

        }


    }
}
