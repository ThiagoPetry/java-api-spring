package br.com.senai.domain.model;

import br.com.senai.api.model.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {

    private String jwt;
    private UsuarioDTO usuario;

}
