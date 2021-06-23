package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OcorrenciaDTO {
    private Long id;
    private String descricao;
    private LocalDateTime dataRegistro;
}
