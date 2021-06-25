package br.com.senai.api.controller;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.api.model.input.PessoaInputDTO;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import br.com.senai.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public List<PessoaDTO> listar() {
        //return pessoaService.listar();
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaDTO> buscar(@PathVariable Long pessoaId) {
        return pessoaService.buscarId(pessoaId);
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<PessoaDTO> listarPorNome(@PathVariable String pessoaNome) {
        return pessoaService.buscarPorNome(pessoaNome);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<PessoaDTO> listarNomeContaining(@PathVariable String nomeContaining) {
        return pessoaService.listarPorNomeContaining(nomeContaining);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO cadastrarPessoa(@Valid @RequestBody PessoaInputDTO pessoaInput){
        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        novaPessoa.getUsuario().setSenha(new BCryptPasswordEncoder().encode(pessoaInput.getUsuario().getSenha()));
        Pessoa pessoa = pessoaService.cadastrarPessoa(novaPessoa);

        return pessoaAssembler.toModel(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public PessoaDTO editarPessoa(@Valid @PathVariable Long pessoaId, @RequestBody PessoaInputDTO pessoaInput){
        if(!pessoaRepository.existsById(pessoaId)){
            throw  new NegocioException("Este usuário não existe.");
        }

        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        novaPessoa.getUsuario().setSenha(new BCryptPasswordEncoder().encode(novaPessoa.getUsuario().getSenha()));
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