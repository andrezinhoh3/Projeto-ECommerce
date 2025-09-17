package br.com.projeto_senai.entregas.controller;

import br.com.projeto_senai.entregas.model.Usuario;
import br.com.projeto_senai.entregas.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Endpoints para gerenciamento de usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }

    // Listar todos
    @GetMapping
    @Operation(summary = "Lista todos os usuarios", description = "Retorna uma lista com todos os usuarios cadastrados")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        List<Usuario> usuario = usuarioService.listarTodos();
        return ResponseEntity.ok().body(usuario);
    }

    // Buscar por Id
    @GetMapping("/{id}")
    @Operation(summary = "Busca um usuario por ID", description = "Retorna um usuario especifico com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuario nao encontrado para o ID informado")
    })
    public ResponseEntity<?> buscarUsuariPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

    // Inserir Novo
    @PostMapping
    @Operation(summary = "Cadastrar um novo usuario", description = "Adiciona um novo usuario ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos para o cadastro")
    })
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);

        if (novoUsuario == null) {
            return ResponseEntity.badRequest().build(); // Retorna 400 sem corpo se a entrada for invalida
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // Atualizar
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um usuario existente", description = "Altera os dados do usuario com base no seu ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario nao encontrado para o ID informado")
    })
    public ResponseEntity<?> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);

        if (usuarioAtualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado");
        }
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um usuario", description = "Usuario excluido com sucesso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario excluido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario nao encontrado para o ID informado")
    })
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
        Usuario deletado = usuarioService.deletar(id);
        if (deletado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao foi possivel excluir, pois o usuario nao foi encontrado");
        }
        return ResponseEntity.ok("Usuario excluido com sucesso");
    }
}
