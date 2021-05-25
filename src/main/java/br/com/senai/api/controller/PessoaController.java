package br.com.senai.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @GetMapping("/pessoas")
    public String listar() {
        return "Teste";
    }
}
