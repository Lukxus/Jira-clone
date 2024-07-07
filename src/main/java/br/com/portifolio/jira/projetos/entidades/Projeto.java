package br.com.portifolio.jira.projetos.entidades;

import br.com.portifolio.jira.usuarios.entidades.Usuario;
import br.com.portifolio.jira.tarefas.entidades.Tarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "projeto_usuarios",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;
}
