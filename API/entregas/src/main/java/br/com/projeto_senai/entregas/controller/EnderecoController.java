package br.com.projeto_senai.entregas.controller;

import br.com.projeto_senai.entregas.model.Endereco;
import br.com.projeto_senai.entregas.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@Tag(name = "Enderecos", description = "Endpoints para gerenciamento de enderecos")
public class EnderecoController {
    private EnderecoService enderecoService;
    public EnderecoController(EnderecoService service) {
        this.enderecoService = service;
    }

    // Listar todos
    @GetMapping
    @Operation(summary = "Lista todos os enderecos", description = "Retorna uma lista com todos os enderecos cadastrados")
    @ApiResponse(responseCode = "200", description = "Operacao bem-sucedida")
    public ResponseEntity<List<Endereco>> listarTodosEnderecos() {
        List<Endereco> endereco = enderecoService.listarTodos();
        return ResponseEntity.ok().body(endereco);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca um endereco por ID", description = "Retorna um endereco especifico com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereco encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereco nao encontrado para o ID informado")
    })
    public ResponseEntity<?> buscarEnderecoPorId(@PathVariable Integer id) {
        Endereco endereco = enderecoService.buscarPorId(id);

        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco nao encontrado");
        }
        return ResponseEntity.ok(endereco);
    }

    // Inserir Novo
    @PostMapping
    @Operation(summary = "Cadastrar um novo endereco", description = "Adiciona um novo endereco ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereco cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos para o cadastro")
    })
    public ResponseEntity<Endereco> inserirEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoNovo = enderecoService.cadastrar(endereco);

        if (enderecoNovo == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoNovo);
    }
}
