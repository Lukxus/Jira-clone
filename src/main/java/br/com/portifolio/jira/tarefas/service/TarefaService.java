package br.com.portifolio.jira.tarefas.service;

import br.com.portifolio.jira.tarefas.dto.CadastroTarefaRequestDTO;
import br.com.portifolio.jira.tarefas.dto.CadastroTarefaResponseDTO;
import br.com.portifolio.jira.tarefas.entidades.Tarefa;
import br.com.portifolio.jira.tarefas.repository.TarefaRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Resource
    private TarefaRepository tarefaRepository;

    public CadastroTarefaResponseDTO cadastraTarefa(CadastroTarefaRequestDTO cadastroTarefaRequestDTO) {

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(cadastroTarefaRequestDTO.getTitulo());
        tarefa.setDescricao(cadastroTarefaRequestDTO.getDescricao());
        tarefa.setDataCriacao(cadastroTarefaRequestDTO.getDataCriacao());
        tarefa.setDataAtivacao(cadastroTarefaRequestDTO.getDataAtivacao());
        tarefa.setDataFinalizacao(cadastroTarefaRequestDTO.getDataFinalizacao());
        tarefa.setStatus(cadastroTarefaRequestDTO.getStatus());

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        CadastroTarefaResponseDTO responseDTO = new CadastroTarefaResponseDTO();
        responseDTO.setId(tarefaSalva.getId());
        responseDTO.setTitulo(tarefaSalva.getTitulo());
        responseDTO.setDescricao(tarefaSalva.getDescricao());
        responseDTO.setDataCriacao(tarefaSalva.getDataCriacao());
        responseDTO.setDataAtivacao(tarefaSalva.getDataAtivacao());
        responseDTO.setDataFinalizacao(tarefaSalva.getDataFinalizacao());
        responseDTO.setStatus(tarefaSalva.getStatus());

        return responseDTO;
    }
}
