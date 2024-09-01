package com.portifolio.jira.auth_service.models.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String login;
    private String password;
}