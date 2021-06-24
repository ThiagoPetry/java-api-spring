package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {

    private long idPessoa;
    private String nomePessoa;
    private UsuarioDTO usuario;
    private String telefonePessoa;
}
