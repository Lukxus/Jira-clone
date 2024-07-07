package br.com.portifolio.jira.projetos.repository;

import br.com.portifolio.jira.projetos.entidades.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
