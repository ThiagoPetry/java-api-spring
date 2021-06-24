package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RoleInputDTO {

    @Id
    @NotBlank
    private String nome_role;
}
