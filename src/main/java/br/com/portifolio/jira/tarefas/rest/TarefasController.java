package br.com.portifolio.jira.tarefas.rest;

import br.com.portifolio.jira.tarefas.dto.CadastroTarefaRequestDTO;
import br.com.portifolio.jira.tarefas.dto.CadastroTarefaResponseDTO;
import br.com.portifolio.jira.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tarefa")
public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<CadastroTarefaResponseDTO> createTarefa(@RequestBody CadastroTarefaRequestDTO requestDTO) {
        CadastroTarefaResponseDTO responseDTO = tarefaService.cadastraTarefa(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
