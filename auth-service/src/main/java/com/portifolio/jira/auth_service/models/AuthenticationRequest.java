package com.portifolio.jira.auth_service.models;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login;
    private String password;
}