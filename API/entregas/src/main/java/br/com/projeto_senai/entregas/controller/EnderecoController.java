package br.com.projeto_senai.entregas.controller;

import br.com.projeto_senai.entregas.model.Endereco;
<<<<<<< HEAD
import br.com.projeto_senai.entregas.model.TipoUsuario;
import br.com.projeto_senai.entregas.model.Usuario;
import br.com.projeto_senai.entregas.service.EnderecoService;
import br.com.projeto_senai.entregas.service.UsuarioService;
=======
import br.com.projeto_senai.entregas.service.EnderecoService;
>>>>>>> 176bc55444fed1fd33200430864b6f6ea12b7997
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
<<<<<<< HEAD
    private final UsuarioService usuarioService;
    private EnderecoService enderecoService;
    public EnderecoController(EnderecoService service, UsuarioService usuarioService) {
        this.enderecoService = service;
        this.usuarioService = usuarioService;
=======
    private EnderecoService enderecoService;
    public EnderecoController(EnderecoService service) {
        this.enderecoService = service;
>>>>>>> 176bc55444fed1fd33200430864b6f6ea12b7997
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
<<<<<<< HEAD

    // Atualizar
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um endereço existente", description = "Altera os dados de um endereço com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado para o ID informado")
    })
    public ResponseEntity<?> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
        Endereco enderecoAtualizado = enderecoService.atualizar(id, endereco);

        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
        }
        return ResponseEntity.ok(enderecoAtualizado);
    }

    // Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um endereço", description = "Remove um endereço do banco de dados com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço excluído com sucesso"),
            @ApiResponse(responseCode = "404", description =  "Endereço não encontrado para o ID informado")
    })
    public ResponseEntity<?> deletarEndereco(@PathVariable Integer id) {
        Endereco deletado = enderecoService.deletar(id);
        if (deletado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao foi possivel excluir, pois o endereço nao foi encontrado");
        }
        return ResponseEntity.ok("Endereço excluido com sucesso");
    }
=======
>>>>>>> 176bc55444fed1fd33200430864b6f6ea12b7997
}
