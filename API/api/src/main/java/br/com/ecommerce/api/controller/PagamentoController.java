package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
@Tag(name = "Pagamentos", description = "Operacoes relacionadas ao pagamentos")
public class PagamentoController {
    private PagamentoService pagamentoService;
    public PagamentoController(PagamentoService pagamento) {
        this.pagamentoService = pagamento;
    }
    @GetMapping
    public ResponseEntity<List<Pagamento>> ListarPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.listarPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    // Cadastrar
    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pagamentoNovo) {
        pagamentoService.cadastrarPagamento(pagamentoNovo);
        return ResponseEntity.ok(pagamentoNovo);
    }

    // Bucar
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPagamentoPorId(@PathVariable Integer id) {
        // 1. Procurar e guardar Pagamento
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        // 2. Se nao encontrar, retorno erro
        if(pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento " + id + " nao encontrado!");
        }
        // 3. Se encontrar, retorno o pagamento
        return ResponseEntity.ok(pagamento);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPagamentoPorId(@PathVariable Integer id) {
        // 1. Verifico se o pagamento existe
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        // 2. Se nao existir retorno erro
        if(pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento " + id + " nao encontrado!");
        }
        // 3. Se existir, retorno ok
        return ResponseEntity.ok(pagamento);
    }
    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPagamento(@PathVariable Integer id, @RequestBody Pagamento pgNovo) {
        // 1. Tento atualizar o cliente
        Pagamento pg = pagamentoService.atualizarPagamento(id, pgNovo);
        // 2. Se nao ahcar o cliente, mostro erro
        if (pg == null) {
            return ResponseEntity.status(404).body("Pagamento nao encontrado!");
        }
        // 3. Se achar retorno ok
        return ResponseEntity.ok(pg);
    }
}
