package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
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
}
