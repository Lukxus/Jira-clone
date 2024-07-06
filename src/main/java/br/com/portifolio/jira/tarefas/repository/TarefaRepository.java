package br.com.portifolio.jira.tarefas.repository;

import br.com.portifolio.jira.tarefas.entidades.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
