package br.com.senai.domain.repository;

import br.com.senai.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByNomeContaining(String nome);
    Optional<Pessoa> findByEmail(String email);
}
