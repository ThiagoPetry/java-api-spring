package br.com.senai.api.assembler;

import br.com.senai.api.model.PessoaDTO;
import br.com.senai.api.model.input.PessoaInputDTO;
import br.com.senai.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PessoaAssembler {

    private ModelMapper modelMapper;

    public PessoaDTO toModel(Pessoa pessoa){
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Pessoa toEntity(PessoaInputDTO pessoaInput) {
        return modelMapper.map(pessoaInput, Pessoa.class);
    }
}
