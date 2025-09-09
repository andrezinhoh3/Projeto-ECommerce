package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    public PagamentoService(PagamentoRepository pagamento) {
        this.pagamentoRepository = pagamento;
    }
    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    // Cadastrar
    public Pagamento cadastrarPagamento(Pagamento pg) {
        return pagamentoRepository.save(pg);
    }
}
