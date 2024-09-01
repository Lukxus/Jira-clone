package com.portifolio.jira.auth_service.controllers;

import com.portifolio.jira.auth_service.models.dto.UsuarioAlterRequestDTO;
import com.portifolio.jira.auth_service.models.dto.UsuarioRequestDTO;
import com.portifolio.jira.auth_service.models.dto.UsuarioResponseDTO;
import com.portifolio.jira.auth_service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO novoUsuario = usuarioService.cadastrarUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping
    public ResponseEntity<UsuarioResponseDTO> atualizarNomeUsuario(@RequestBody UsuarioAlterRequestDTO usuarioAlterRequestDTO) {
        UsuarioResponseDTO usuarioAtualizado = usuarioService.atualizarNomeUsuario(usuarioAlterRequestDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
