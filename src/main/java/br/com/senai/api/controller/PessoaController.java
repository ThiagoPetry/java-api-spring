package br.com.senai.api.controller;

import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

//    @PersistenceContext
//    private EntityManager entityManager;

//    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar() {
//        return entityManager.createQuery("FROM Pessoa", Pessoa.class).getResultList();
        return pessoaRepository.findAll();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<Pessoa> listarPorNome(@PathVariable String pessoaNome) {
        return pessoaRepository.findByNome(pessoaNome);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<Pessoa> listarNomeContaining(@PathVariable String nomeContaining) {
        return pessoaRepository.findByNomeContaining(nomeContaining);
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
//        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
//
//        if(pessoa.isPresent()) {
//            return ResponseEntity.ok(pessoa.get());
//        }
//        return ResponseEntity.notFound().build();

        return pessoaRepository.findById(pessoaId)
                    .map(pessoa -> ResponseEntity.ok(pessoa))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pessoa cadastrar(@Valid @RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> editar(@Valid @PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{pessoaId}")
    public  ResponseEntity<Pessoa> remover(@PathVariable Long pessoaId) {
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        pessoaRepository.deleteById(pessoaId);

        return ResponseEntity.noContent().build();
    }
}