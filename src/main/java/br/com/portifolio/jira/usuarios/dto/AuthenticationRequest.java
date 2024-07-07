package br.com.portifolio.jira.usuarios.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String senha;
}
