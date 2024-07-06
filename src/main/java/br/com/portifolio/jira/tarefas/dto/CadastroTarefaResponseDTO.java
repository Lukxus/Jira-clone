package br.com.portifolio.jira.tarefas.dto;

import br.com.portifolio.jira.tarefas.entidades.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroTarefaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtivacao;
    private LocalDateTime dataFinalizacao;
    private StatusTarefa status;
}
