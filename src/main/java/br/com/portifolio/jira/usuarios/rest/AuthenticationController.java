package br.com.portifolio.jira.usuarios.rest;

import br.com.portifolio.jira.config.JwtUtil;
import br.com.portifolio.jira.usuarios.dto.AuthenticationRequest;
import br.com.portifolio.jira.usuarios.dto.AuthenticationResponse;
import br.com.portifolio.jira.usuarios.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // Autentica o usuário
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getSenha())
        );

        // Define o contexto de segurança
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Carrega os detalhes do usuário e gera o token JWT
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        // Retorna a resposta com o token JWT
        return new AuthenticationResponse(jwt);
    }
}
