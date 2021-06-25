package br.com.senai.api.assembler;

import br.com.senai.api.model.RoleDTO;
import br.com.senai.api.model.input.RoleInputDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuarios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class RoleAssembler {

    private ModelMapper modelMapper;

    public RoleDTO toModel(Role role){
        return modelMapper.map(role, RoleDTO.class);
    }

    public List<RoleDTO> toCollectionModel(List<Role> roles) {
        return roles.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Role toEntity(RoleInputDTO roleInputDTO) {
        return modelMapper.map(roleInputDTO, Role.class);
    }
}
