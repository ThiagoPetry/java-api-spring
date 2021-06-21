package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PessoaInput {

    @Valid
    @NotBlank
    private String nome;

    @Valid
    @NotBlank
    @Email
    private String email;

    @Valid
    @NotBlank
    @Size(max = 15, min = 10)
    private String telefone;
}
