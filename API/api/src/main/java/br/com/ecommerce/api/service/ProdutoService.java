package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository service) {
        this.produtoRepository = service;
    }

    // Listar todos Produtos
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}
