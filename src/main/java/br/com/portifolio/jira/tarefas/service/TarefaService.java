package br.com.portifolio.jira.tarefas.service;

import br.com.portifolio.jira.projetos.entidades.Projeto;
import br.com.portifolio.jira.projetos.repository.ProjetoRepository;
import br.com.portifolio.jira.tarefas.dto.CadastroTarefaRequestDTO;
import br.com.portifolio.jira.tarefas.dto.CadastroTarefaResponseDTO;
import br.com.portifolio.jira.tarefas.entidades.Tarefa;
import br.com.portifolio.jira.tarefas.repository.TarefaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public CadastroTarefaResponseDTO cadastraTarefa(CadastroTarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa(dto);
        if (dto.getProjetoId() != null) {
            Projeto projeto = projetoRepository.findById(dto.getProjetoId()).orElse(null);
            tarefa.setProjeto(projeto);
        }
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return mapToResponseDTO(tarefaSalva);
    }

    public List<CadastroTarefaResponseDTO> getAllTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    private CadastroTarefaResponseDTO mapToResponseDTO(Tarefa tarefa) {
        CadastroTarefaResponseDTO responseDTO = new CadastroTarefaResponseDTO();
        BeanUtils.copyProperties(tarefa, responseDTO);
        return responseDTO;
    }
}
