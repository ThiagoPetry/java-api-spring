package br.com.senai.domain.service;

import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa) {
        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getEmail()).isPresent();

        if(emailValidation) {
            throw  new NegocioException("Já existe uma pessoa com este e-mail cadastrado.");
        }

        return pessoaRepository.save(pessoa);
    }
}
