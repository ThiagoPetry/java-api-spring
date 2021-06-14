package br.com.senai.api.controller;

import br.com.senai.api.assembler.EntregaAssembler;
import br.com.senai.api.model.EntregaModel;
import br.com.senai.api.model.input.EntregaInput;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.repository.EntregaRepository;
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
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entrega = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toModel(entrega);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return solicitacaoEntregaService.listar();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return solicitacaoEntregaService.buscar(entregaId);
    }

}
