package br.com.portifolio.jira.tarefas.dto;

import br.com.portifolio.jira.tarefas.entidades.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroTarefaRequestDTO {
    private String titulo;
    private String descricao;
    private StatusTarefa status;
}
