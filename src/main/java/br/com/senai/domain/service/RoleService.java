package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleRepository;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {

    private RoleRepository roleRepository;
    private RoleAssembler roleAssembler;

    public List<RoleDTO> listar() {
        return roleAssembler.toCollectionModel(roleRepository.findAll());
    }

    @Transactional
    public Role cadastrarRole(Role role) {
        return roleRepository.save(role);
    }
}
