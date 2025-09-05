package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
