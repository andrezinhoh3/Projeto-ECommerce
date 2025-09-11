package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemdospedidos")
@Tag(name = "ItemdoPedido", description = "Operacoes relacionadas ao item do pedido ")
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

    // Buscar
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarItemDoPedido(@PathVariable Integer id) {
        // 1. Procurar e guardar o Item
        ItemDoPedido itemDoPedido = itemPedidoService.buscarItemDoPedidoPorId(id);
        // 2. Se nao encontrar, retorno um erro
        if(itemDoPedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");
        }
        // 3. Se encontrar, retorno o Item
        return ResponseEntity.ok(itemDoPedido);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarItemDoPedido(@PathVariable Integer id) {
        // 1. Verifico se o Item existe
        ItemDoPedido itemDoPedido = itemPedidoService.deletarItemDoPedidoPorId(id);
        // 2. Se nao existir, retorno um erro
        if(itemDoPedido == null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");
        }
        // 3. Se existir, retorno ok
        return ResponseEntity.ok(itemDoPedido);
    }

}
