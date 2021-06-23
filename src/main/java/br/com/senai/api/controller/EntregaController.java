package br.com.senai.api.controller;

import br.com.senai.api.assembler.EntregaAssembler;
import br.com.senai.api.model.EntregaDTO;
import br.com.senai.api.model.input.EntregaInputDTO;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.service.EntregaService;
import br.com.senai.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaAssembler entregaAssembler;
    private EntregaService entregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody EntregaInputDTO entregaInput){
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entrega = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toModel(entrega);
    }

    @GetMapping
    public List<EntregaDTO> listar() {
        return solicitacaoEntregaService.listar();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
        return solicitacaoEntregaService.buscar(entregaId);
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable long entregaId) {
        entregaService.finalizar(entregaId);
    }
}
