package br.com.senai.api.controller;

import br.com.senai.domain.model.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PessoaController {

    @GetMapping("/pessoas")
    public List<Pessoa> listar() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();

        pessoa1.setId(1L);
        pessoa1.setNome("Thiago");
        pessoa1.setEmail("thiagokeiserpetry@gmail.com");
        pessoa1.setTelefone("47984238681");

        pessoa2.setId(2L);
        pessoa2.setNome("Ana");
        pessoa2.setEmail("ana@gmail.com");
        pessoa2.setTelefone("47940028922");

        return Arrays.asList(pessoa1, pessoa2);
    }
}
