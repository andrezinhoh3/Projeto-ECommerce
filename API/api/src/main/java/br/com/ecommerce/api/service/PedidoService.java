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
}
