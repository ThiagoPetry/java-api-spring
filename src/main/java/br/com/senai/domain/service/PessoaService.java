package br.com.senai.domain.service;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;
    private RoleService roleService;

    @Transactional
    public void excluir(Long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
//        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getEmail()).isPresent();
//
//        if(emailValidation) {
//            throw  new NegocioException("Já existe uma pessoa com este e-mail cadastrado!");
//        }

        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        RoleUsuarios novaRole = new RoleUsuarios();

        novaRole.setUsuarios_id(novaPessoa.getUsuario().getId());
        novaRole.setRole_nome_role("ROLE_USER");

        roleService.cadastrarRole(novaRole);

        return novaPessoa;
    }

    public List<PessoaDTO> listar() {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

    public List<PessoaDTO> listarPorNomeContaining(String nomeContaining) {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNomeContaining(nomeContaining));
    }

    public ResponseEntity<PessoaDTO> buscarId(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .map(pessoa -> {
                    return ResponseEntity.ok(pessoaAssembler.toModel(pessoa));
                }).orElse(ResponseEntity.notFound().build());
    }

    public List<PessoaDTO> buscarPorNome(String pessoaNome) {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNome(pessoaNome));
    }

    public Pessoa buscarRemetente(long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new NegocioException("Essa pessoa não existe!"));
    }

    public Pessoa editarPessoa(Pessoa pessoa, long pessoaId) {
        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);
        return pessoa;
    }

//    public Role cadastrarRole(Role role, long pessoaId) {
//        role.setNomeRole(role.getNomeRole());
//        role = pessoaRepository.save(role);
//        return role;
//    }
}
