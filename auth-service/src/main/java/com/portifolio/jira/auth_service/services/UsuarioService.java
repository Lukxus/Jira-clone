package com.portifolio.jira.auth_service.services;


import com.portifolio.jira.auth_service.models.Usuario;
import com.portifolio.jira.auth_service.models.dto.UsuarioAlterRequestDTO;
import com.portifolio.jira.auth_service.models.dto.UsuarioRequestDTO;
import com.portifolio.jira.auth_service.models.dto.UsuarioResponseDTO;
import com.portifolio.jira.auth_service.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        usuario.setPassword(bCryptPasswordEncoder.encode(dto.getPassword())); // Hashear a senha
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return mapToResponseDTO(usuarioSalvo);
    }

    private UsuarioResponseDTO mapToResponseDTO(Usuario usuario) {
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        BeanUtils.copyProperties(usuario, responseDTO);
        return responseDTO;
    }

    public UsuarioResponseDTO atualizarNomeUsuario(UsuarioAlterRequestDTO dto) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByLogin(dto.getLogin());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(dto.getNome());
            usuarioRepository.save(usuario);
            UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
            BeanUtils.copyProperties(usuario, responseDTO);
            return responseDTO;
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}