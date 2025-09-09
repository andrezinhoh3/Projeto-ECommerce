package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;
    public ItemPedidoService(ItemPedidoRepository itemPedido) {
        this.itemPedidoRepository = itemPedido;
    }
    public List<ItemDoPedido> listarItemdoPedidos() {
        return itemPedidoRepository.findAll();
    }

    // Cadatrar
    public ItemDoPedido cadastrarItemDoPedido(ItemDoPedido itemDoPedido) {
        return itemPedidoRepository.save(itemDoPedido);
    }
}
