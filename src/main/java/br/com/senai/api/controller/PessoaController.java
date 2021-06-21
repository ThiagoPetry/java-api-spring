package br.com.senai.api.controller;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.PessoaInput;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import br.com.senai.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;
    private PessoaAssembler pessoaAssembler;

    @GetMapping
    public List<PessoaModel> listar() {
        return pessoaService.listar();
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaModel> buscar(@PathVariable Long pessoaId) {
        return pessoaService.buscarId(pessoaId);
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<PessoaModel> listarPorNome(@PathVariable String pessoaNome) {
        return pessoaService.buscarPorNome(pessoaNome);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<PessoaModel> listarNomeContaining(@PathVariable String nomeContaining) {
        return pessoaService.listarPorNomeContaining(nomeContaining);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel cadastrarPessoa(@Valid @RequestBody PessoaInput pessoaInput){
        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        Pessoa pessoa = pessoaService.cadastrarPessoa(novaPessoa);

        return pessoaAssembler.toModel(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public PessoaModel editarPessoa(@Valid @PathVariable Long pessoaId, @RequestBody PessoaInput pessoaInput){
        if(!pessoaRepository.existsById(pessoaId)){
            throw  new NegocioException("Este usuário não existe.");
        }

        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        Pessoa pessoa = pessoaService.editarPessoa(novaPessoa, pessoaId);

        return pessoaAssembler.toModel(pessoa);
    }


    @DeleteMapping("/{pessoaId}")
    public  ResponseEntity<Pessoa> remover(@PathVariable Long pessoaId) {
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }
        pessoaService.excluir(pessoaId);

        return ResponseEntity.noContent().build();
    }
}