package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.service.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemdospedidos")
public class ItemPedidoController {
    private ItemPedidoService itemPedidoService;
    public ItemPedidoController(ItemPedidoService itemPedido) {
        this.itemPedidoService = itemPedido;
    }
    @GetMapping
    public ResponseEntity<List<ItemDoPedido>> listarPedidos() {
        List<ItemDoPedido> itemDoPedido = itemPedidoService.listarItemdoPedidos();
        return ResponseEntity.ok(itemDoPedido);
    }

    // Cadastrar
    @PostMapping
    public ResponseEntity<ItemDoPedido> cadastrarItemDoPedido(@RequestBody ItemDoPedido itemDoPedido) {
        itemPedidoService.cadastrarItemDoPedido(itemDoPedido);
        return ResponseEntity.ok(itemDoPedido);
    }
}
