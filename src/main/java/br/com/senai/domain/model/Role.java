package br.com.senai.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority {

    @Id
    private String nomeRole;

    @ManyToMany
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}
