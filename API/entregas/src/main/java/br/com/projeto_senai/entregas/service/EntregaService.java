package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.Entrega;
import br.com.projeto_senai.entregas.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    private EntregaRepository entregaRepository;
    public EntregaService(EntregaRepository repo) {
        this.entregaRepository = repo;
    }

    // Listar
    public List<Entrega> listarTodos() {
        return this.entregaRepository.findAll();
    }

    // Buscar por ID
    public Entrega buscarPorId(Integer id) {
        return entregaRepository.findById(id).orElse(null);
    }

    // Cadastrar
    public Entrega cadastrar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    // Atualizar
    public Entrega atualizar(Integer id, Entrega entregaNovo) {
        Entrega entregaExistente = buscarPorId(id);
        if (entregaExistente == null) {
            return null;
        }
        entregaExistente.setDescricaoProduto(entregaNovo.getDescricaoProduto());
        entregaExistente.setStatus(entregaNovo.getStatus());
        entregaExistente.setDataPedido(entregaNovo.getDataPedido());
        return entregaRepository.save(entregaExistente);
    }

    // Deletar
    public Entrega deletar(Integer id) {
        Entrega entregaExistente = buscarPorId(id);
        if (entregaExistente == null) {
            return  null;
        }
        entregaRepository.delete(entregaExistente);
        return entregaExistente;
    }
}
