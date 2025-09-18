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
    // Buscar
    public Pagamento buscarPorId(Integer id) {
        return pagamentoRepository.findById(id).orElse(null);
    }
    // Deletar
    public Pagamento deletarPagamento(Integer id) {
        // 1. Verifico se o pagamento existe
        Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);
        // 2. Se nao existir, retorno nulo
        if(pagamento == null) {
            return null;
        }
        // 3. Se existir, excluo
        pagamentoRepository.delete(pagamento);
        return pagamento;
    }
    // Atualizar
    public Pagamento atualizarPagamento(Integer id, Pagamento pgNovo) {
        // 1. Procurar quem eu quero atualizar
        Pagamento pagamentoAntigo = buscarPorId(id);
        // 2. Se eu nao achar, retorno nulo
        if (pagamentoAntigo == null) {
            return null;
        }
        // 3. Se eu achar eu atualizo
        pagamentoAntigo.setDataPagamento(pgNovo.getDataPagamento());
        pagamentoAntigo.setFormaPagamento(pgNovo.getFormaPagamento());
        pagamentoAntigo.setStatus(pgNovo.getStatus());
        return pagamentoRepository.save(pagamentoAntigo);
    }
}
