package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.api.model.input.RoleInputDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import br.com.senai.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;
    private RoleAssembler roleAssembler;
    private RoleUsuarioRepository roleUsuarioRepository;

    @GetMapping
    public List<RoleDTO> listar() {
        return roleService.listar();
        //return roleAssembler.toCollectionModel(roleUsuarioRepository.findAll());
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public RoleDTO cadastrarRole(@Valid @RequestBody RoleInputDTO roleInputDTO){
        Role novaRole = roleAssembler.toEntity(roleInputDTO);
        Role role = roleService.cadastrarRole(novaRole);

        return roleAssembler.toModel(role);
    }
}
