package br.com.portifolio.jira.usuarios.dto;

import br.com.portifolio.jira.usuarios.entidades.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private String nome;
    private String login;
    private RolesEnum roles;
    private String password; // Campo para senha
}
