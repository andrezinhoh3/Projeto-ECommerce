package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService service) {
        this.pedidoService = service;
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> ListarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }
}

