package com.portifolio.jira.auth_service.models;


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