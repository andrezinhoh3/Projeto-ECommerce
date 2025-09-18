package br.com.projeto_senai.entregas.controller;

import br.com.projeto_senai.entregas.model.Veiculo;
import br.com.projeto_senai.entregas.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@Tag(name = "Veiculos", description = "Endpoints para gerenciamento de veiculos")
public class VeiculoController {
    private VeiculoService veiculoService;
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // Listar todos
    @GetMapping
    @Operation(summary = "Lista todos os veiculos", description = "Retorna uma lista com todos os veiculos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
    public ResponseEntity<List<Veiculo>> listarVeiculo() {
        List<Veiculo> veiculo = veiculoService.listarTodos();
        return ResponseEntity.ok().body(veiculo);
    }

    // Buscar Por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca um veiculo por ID", description = "Retorna um veiculo específico com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Veiculo não encontrado para o ID informado")
    })
    public ResponseEntity<?> buscarVeiculoPorId(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);

        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
        }
        return ResponseEntity.ok(veiculo);
    }

    // Inserir Novo
    @PostMapping
    @Operation(summary = "Cadastra um novo veiculo", description = "Adiciona um novo veiculo ao banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Veiculo cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para o cadastro")
    })
    public ResponseEntity<Veiculo> inserirVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo veiculoNovo = veiculoService.cadastarVeiculo(veiculo);

        if (veiculoNovo == null) {
            return ResponseEntity.badRequest().build(); // Retorna 400 sem corpo se  entrada for invalida
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoNovo);
    }

    // Atualizar
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um veiculo existente", description = "Altera os dados de um veiculo com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Veiculo não encontrado para o ID informado")
    })
    public ResponseEntity<?> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
         Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);

         if (veiculoAtualizado == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
         }
         return ResponseEntity.ok(veiculoAtualizado);
    }

    // Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um veiculo", description = "Remove um veiculo do banco de dados com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Veiculo não encontrado para o ID informado")
    })
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id) {
        Veiculo deletado = veiculoService.deletar(id);

        if (deletado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel excluir, pois o veiculo nao foi encontrado");
        }
        return ResponseEntity.ok("Veiculo excluido com sucesso");
    }
}
