//package br.com.senai.api.controller;
//
//import br.com.senai.api.assembler.PessoaAssembler;
//import br.com.senai.api.model.RoleDTO;
//import br.com.senai.api.model.input.RoleInputDTO;
//import br.com.senai.domain.model.Role;
//import br.com.senai.domain.repository.PessoaRepository;
//import br.com.senai.domain.service.PessoaService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping("/role")
//public class RoleController {
//
//    private PessoaRepository pessoaRepository;
//    private PessoaService pessoaService;
//    private PessoaAssembler pessoaAssembler;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public RoleDTO cadastrarRole(@Valid @RequestBody RoleInputDTO roleInputDTO){
//        Role novaRole = pessoaAssembler.toEntity(roleInputDTO);
//        Role role = pessoaService.cadastrarPessoa(novaRole);
//
//        return pessoaAssembler.toModel(role);
//    }
//}
