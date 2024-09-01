package com.portifolio.jira.auth_service.models.dto;


import com.portifolio.jira.auth_service.models.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAlterRequestDTO {
    private String nome;
    private String login;
    private RolesEnum roles;
}