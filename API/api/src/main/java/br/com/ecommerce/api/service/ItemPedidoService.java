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

    // Buscar
    public ItemDoPedido buscarItemDoPedidoPorId(Integer id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    // Deletar
    public ItemDoPedido deletarItemDoPedidoPorId(Integer id) {
        // 1. Verifico se o Item existe
        ItemDoPedido itemDoPedido = buscarItemDoPedidoPorId(id);
        // 2. Se nao existir, retorno nulo
        if(itemDoPedido == null) {
            return null;
        }
        // 3. Se existir, excluo
        itemPedidoRepository.delete(itemDoPedido);
        return itemDoPedido;
    }
    // Atualizar
    public ItemDoPedido atualizarItemDoPedido(Integer id, ItemDoPedido itemDoPedidoNovo) {
        // 1. Procurar quem eu quero atualizar
        ItemDoPedido itemDoPedidoAntigo = buscarItemDoPedidoPorId(id);
        // 2. Se eu nao achar, retorno nulo
        if (itemDoPedidoAntigo == null) {
        return null;
        }
        // 3. Se eu achar eu atualizo
        itemDoPedidoAntigo.setQuantidade(itemDoPedidoAntigo.getQuantidade());
        return itemPedidoRepository.save(itemDoPedidoAntigo);
    }
}
