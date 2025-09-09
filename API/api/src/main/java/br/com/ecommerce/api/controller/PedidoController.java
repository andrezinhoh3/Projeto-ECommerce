package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.ClienteService;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final ClienteService clienteService;
    private PedidoService pedidoService;
    public PedidoController(PedidoService service, ClienteService clienteService) {
        this.pedidoService = service;
        this.clienteService = clienteService;
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
}

