package br.com.portifolio.jira.usuarios.service;

import br.com.portifolio.jira.usuarios.dto.UsuarioRequestDTO;
import br.com.portifolio.jira.usuarios.dto.UsuarioResponseDTO;
import br.com.portifolio.jira.usuarios.entidades.Usuario;
import br.com.portifolio.jira.usuarios.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        usuario.setSenha(passwordEncoder.encode(dto.getSenha())); // Hashear a senha
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return mapToResponseDTO(usuarioSalvo);
    }

    private UsuarioResponseDTO mapToResponseDTO(Usuario usuario) {
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        BeanUtils.copyProperties(usuario, responseDTO);
        return responseDTO;
    }
}
