package br.com.portifolio.jira.projetos.service;

import br.com.portifolio.jira.projetos.dto.ProjetoRequestDTO;
import br.com.portifolio.jira.projetos.dto.ProjetoResponseDTO;
import br.com.portifolio.jira.projetos.entidades.Projeto;
import br.com.portifolio.jira.projetos.repository.ProjetoRepository;
import br.com.portifolio.jira.usuarios.entidades.Usuario;
import br.com.portifolio.jira.usuarios.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ProjetoResponseDTO criarProjeto(ProjetoRequestDTO dto) {
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(dto, projeto);
        Projeto projetoSalvo = projetoRepository.save(projeto);
        return mapToResponseDTO(projetoSalvo);
    }

    public ProjetoResponseDTO adicionarUsuario(Long projetoId, Long usuarioId) {
        Projeto projeto = projetoRepository.findById(projetoId).orElse(null);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (projeto != null && usuario != null) {
            projeto.getUsuarios().add(usuario);
            projeto = projetoRepository.save(projeto);
        }
        return mapToResponseDTO(projeto);
    }

    public List<ProjetoResponseDTO> getTodosProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        return projetos.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public ProjetoResponseDTO getProjetoPorId(Long id) {
        Projeto projeto = projetoRepository.findById(id).orElse(null);
        return mapToResponseDTO(projeto);
    }

    private ProjetoResponseDTO mapToResponseDTO(Projeto projeto) {
        ProjetoResponseDTO responseDTO = new ProjetoResponseDTO();
        BeanUtils.copyProperties(projeto, responseDTO);
        return responseDTO;
    }
}
