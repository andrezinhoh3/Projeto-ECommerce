package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.ClienteService;
import br.com.ecommerce.api.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Operacoes relacionadas ao pedido")
public class PedidoController {
    private PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> ListarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    // Cadastrar
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedidoNovo) {
        pedidoService.cadastrarPedido(pedidoNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoNovo);
    }

    // Buscar
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id) {
        // 1. Procurar e guardar o pedido
        Pedido pedido = pedidoService.buscarPorId(id);
        // 2. Se nao encontrar, retorno um erro
        if(pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " nao encontrado!");
        }
        // 3. se encontrar, retorno o pedido
        return ResponseEntity.ok(pedido);
    }
    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedidoPorId(@PathVariable Integer id) {
        // 1. Verifico se o pedido existe
        Pedido pedido = pedidoService.deletarPedido(id);
        // 2. Se nao existir, retorno erro
        if( pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " nao encontrado!");
        }
        // 3. Se existir, retorno ok
        return ResponseEntity.ok(pedido);
    }
}

