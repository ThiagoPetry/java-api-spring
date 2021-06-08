package br.com.senai.api.controller;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar() {
        return solicitacaoEntregaService.listar();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
        return solicitacaoEntregaService.buscar(entregaId);
    }

}
