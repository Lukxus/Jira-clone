package br.com.portifolio.jira.projetos.dto;

import br.com.portifolio.jira.tarefas.entidades.Tarefa;
import br.com.portifolio.jira.usuarios.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoResponseDTO {
    private Long id;
    private String nome;
    private List<Usuario> usuarios;
    private List<Tarefa> tarefas;
}
