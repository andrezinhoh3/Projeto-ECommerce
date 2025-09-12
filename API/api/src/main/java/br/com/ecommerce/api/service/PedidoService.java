package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedido) {
        this.pedidoRepository = pedido;
    }
    public List<Pedido> listarPedidos () {
        return pedidoRepository.findAll();
    }
    // Cadastrar
    public Pedido cadastrarPedido(Pedido p) {
        return pedidoRepository.save(p);
    }
    // Buscar
    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    // Deletar
    public Pedido deletarPedido(Integer id) {
        // 1. Verifico se o Pedido existe
        Pedido pedido = buscarPorId(id);
        // 2. Se nao existir, retorno nulo
        if (pedido == null) {
            return null;
        }
        // 3. Se existir, excluo
        pedidoRepository.delete(pedido);
        return pedido;
    }

    // Atualizar
    public Pedido atualizarPedido(Integer id, Pedido pedidoNovo) {
        // 1. Procurar quem eu quero atualizar
        Pedido pedidoAntigo = buscarPorId(id);
        // 2. Se eu nao achar, retorno nulo
        if (pedidoAntigo == null) {
            return null;
        }
        // 3. Se eu nao achar eu atualizo
        pedidoAntigo.setDataPedido(pedidoNovo.getDataPedido());
        pedidoAntigo.setStatus(pedidoNovo.getStatus());
        pedidoAntigo.setValorTotal(pedidoNovo.getValorTotal());
        return pedidoRepository.save(pedidoAntigo);
    }
}
