package br.com.portifolio.jira.usuarios.rest;

import br.com.portifolio.jira.usuarios.dto.UsuarioRequestDTO;
import br.com.portifolio.jira.usuarios.dto.UsuarioResponseDTO;
import br.com.portifolio.jira.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
