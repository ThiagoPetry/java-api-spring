package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
//    private Long idPessoa;
//    private String nomePessoa;
//    private String emailPessoa;
//    private String telefonePessoa;
//    private UsuarioDTO usuario;

    private String nomePessoa;
    private UsuarioDTO usuario;
    private String telefonePessoa;
}
