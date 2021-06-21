package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaModel {
    private Long idPessoa;
    private String nomePessoa;
    private String emailPessoa;
    private String telefonePessoa;
}
