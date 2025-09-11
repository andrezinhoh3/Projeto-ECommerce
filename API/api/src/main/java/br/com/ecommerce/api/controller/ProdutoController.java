package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "Operacoes relacionadas ao produto")
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

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Integer id) {
        // 1. Procurar e guardar o Produto
        Produto produto = produtoService.buscarPorId(id);
        // 2. Se nao encontrar, retorno um erro
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " nao encontrado!");
        }
       // 3. Se encontrar, retorno o Produto
        return  ResponseEntity.ok(produto);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Integer id) {
        // 1. Verifico se o Produto existe
        Produto produto = produtoService.deletarProduto(id);
        // 2. Se nao existir retorno erro
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " nao encontrado!");
        }
        // 3. Se nao existir, retorno ok
        return ResponseEntity.ok(produto);
    }
}
