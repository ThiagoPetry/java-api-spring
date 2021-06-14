package br.com.senai.api.model;

import br.com.senai.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EntregaModel {

    private Long id;
    private PessoaModel Pessoa;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
}
