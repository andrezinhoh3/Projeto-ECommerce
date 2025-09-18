package br.com.projeto_senai.entregas.controller;

import br.com.projeto_senai.entregas.model.Entrega;
import br.com.projeto_senai.entregas.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
@Tag(name = "Entregas", description = "Endpoints para gerenciamento de entregas")
public class EntregaController {
    private EntregaService entregaService;
    public EntregaController(EntregaService service) {
        this.entregaService = service;
    }

    // Listar todos
    @GetMapping
    @Operation(summary = "Lista todos as entregas", description = "Retorna uma lista com todas as entregas cadastrados")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
    public ResponseEntity<List<Entrega>> listarEntrega() {
        List<Entrega> entrega = entregaService.listarTodos();
        return ResponseEntity.ok().body(entrega);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca uma entrega por ID", description = "Retorna uma entrega específica com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrega encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrado para o ID informado")
    })
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Entrega entrega = entregaService.buscarPorId(id);

        if (entrega == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega não encontrado");
        }
        return ResponseEntity.ok(entrega);
    }

    // Inserir Novo
    @PostMapping
    @Operation(summary = "Cadastra uma nova entrega", description = "Adiciona uma nova entrega ao banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entrega cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para o cadastro")
    })
    public ResponseEntity<Entrega> inserirEntrega(@RequestBody Entrega entrega) {
        Entrega entregaNova = entregaService.cadastrar(entrega);

        if (entregaNova == null) {
            return ResponseEntity.badRequest().build(); //Retorna 400 sem corpo se a entrada for invalida
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(entregaNova);
    }

    // Atualizar
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma entrega existente", description = "Altera os dados de uma entrega com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrega atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrado para o ID informado")
    })
    public ResponseEntity<?> atualizarEntrega(@PathVariable Integer id, @RequestBody Entrega entrega) {
        Entrega entregaAtualizado = entregaService.atualizar(id, entrega);

        if (entregaAtualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega não encontrado");
        }
        return ResponseEntity.ok(entregaAtualizado);
    }

    // Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma entrega", description = "Remove uma entrega do banco de dados com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrega excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrado para o ID informado")
    })
    public ResponseEntity<?> deletarEntrega(@PathVariable Integer id) {
        Entrega deletado = entregaService.deletar(id);
        if (deletado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel excluir, pois a entrega não foi encontrado");
        }
        return ResponseEntity.ok("Entrega excluido com sucesso");
    }
}
