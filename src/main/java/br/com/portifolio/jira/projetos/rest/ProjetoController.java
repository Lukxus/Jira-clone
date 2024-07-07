package br.com.portifolio.jira.projetos.rest;

import br.com.portifolio.jira.projetos.dto.ProjetoRequestDTO;
import br.com.portifolio.jira.projetos.dto.ProjetoResponseDTO;
import br.com.portifolio.jira.projetos.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody ProjetoRequestDTO projetoRequestDTO) {
        ProjetoResponseDTO novoProjeto = projetoService.criarProjeto(projetoRequestDTO);
        return ResponseEntity.ok(novoProjeto);
    }

    @PostMapping("/{projetoId}/usuarios/{usuarioId}")
    public ResponseEntity<ProjetoResponseDTO> adicionarUsuario(@PathVariable Long projetoId, @PathVariable Long usuarioId) {
        ProjetoResponseDTO projetoAtualizado = projetoService.adicionarUsuario(projetoId, usuarioId);
        return ResponseEntity.ok(projetoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> getTodosProjetos() {
        List<ProjetoResponseDTO> projetos = projetoService.getTodosProjetos();
        return ResponseEntity.ok(projetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> getProjetoPorId(@PathVariable Long id) {
        ProjetoResponseDTO projeto = projetoService.getProjetoPorId(id);
        return ResponseEntity.ok(projeto);
    }
}
