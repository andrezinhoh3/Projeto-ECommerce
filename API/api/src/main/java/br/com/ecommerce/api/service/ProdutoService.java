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

    //Cadastrar
    public Produto cadastrarProduto(Produto pd) {
        return produtoRepository.save(pd);
    }

    // Buscar cliente por ID
    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    // Deletar
    public Produto deletarProduto(Integer id) {
        // 1. Verifico se o Produto existe
        Produto produto = buscarPorId(id);

        // 2. Se nao existir, retorno nulo
        if(produto == null) {
            return null;
        }
        // 3. Se existir, excluo
        produtoRepository.delete(produto);
        return produto;
    }

    // Atualizar
    public Produto atualizarProduto(Integer id, Produto produtoNovo) {
        // 1. Procurar quem eu quero atualizar
        Produto produtoAntigo = buscarPorId(id);
        // 2. Se eu nao acha, retorno nulo
        if (produtoAntigo == null) {
            return null;
        }
        // 3. Se eu nao achar eu atualizo
        produtoAntigo.setNomeCompleto(produtoNovo.getNomeCompleto());
        produtoAntigo.setPreco(produtoNovo.getPreco());
        produtoAntigo.setDescricao(produtoNovo.getDescricao());
        produtoAntigo.setEstoqueDisponivel(produtoNovo.getEstoqueDisponivel());
        produtoAntigo.setImagemUrl(produtoNovo.getImagemUrl());
        return produtoRepository.save(produtoAntigo);
    }
}
