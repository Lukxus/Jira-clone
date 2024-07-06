package br.com.portifolio.jira.tarefas.service;

import br.com.portifolio.jira.tarefas.dto.CadastroTarefaRequestDTO;
import br.com.portifolio.jira.tarefas.dto.CadastroTarefaResponseDTO;
import br.com.portifolio.jira.tarefas.entidades.Tarefa;
import br.com.portifolio.jira.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public CadastroTarefaResponseDTO cadastraTarefa(CadastroTarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa(dto);
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
