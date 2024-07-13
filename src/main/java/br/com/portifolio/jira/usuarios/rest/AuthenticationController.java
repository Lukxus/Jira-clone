package br.com.portifolio.jira.usuarios.rest;

import br.com.portifolio.jira.infra.security.TokenService;
import br.com.portifolio.jira.usuarios.dto.AuthenticationRequest;
import br.com.portifolio.jira.usuarios.dto.AuthenticationResponse;
import br.com.portifolio.jira.usuarios.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
