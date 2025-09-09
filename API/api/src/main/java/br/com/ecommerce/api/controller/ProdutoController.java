package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    //Controller -> Service
    private ProdutoService produtoService;
    public ProdutoController(ProdutoService service) {
        this.produtoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> ListarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }
    // Cadastrar
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produtoNovo) {
        produtoService.cadastrarProduto(produtoNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoNovo);
    }
}
