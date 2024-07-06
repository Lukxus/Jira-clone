package br.com.portifolio.jira.tarefas.entidades;

import br.com.portifolio.jira.tarefas.dto.CadastroTarefaRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 300, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = true)
    private LocalDateTime dataAtivacao;

    @Column(nullable = true)
    private LocalDateTime dataFinalizacao;

    @Column(nullable = true)
    private StatusTarefa status;

    public Tarefa(CadastroTarefaRequestDTO dto) {
        BeanUtils.copyProperties(dto, this);
        this.dataCriacao = LocalDateTime.now();
    }
}
