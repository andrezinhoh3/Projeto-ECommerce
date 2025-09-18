package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.Endereco;
import br.com.projeto_senai.entregas.model.Usuario;
import br.com.projeto_senai.entregas.repository.EnderecoRepository;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;
    public EnderecoService(EnderecoRepository repo) {
        this.enderecoRepository = repo;
    }

    // Listar
    public List<Endereco> listarTodos() {
        return this.enderecoRepository.findAll();
    }

    // Buscar por ID
    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    // Cadastar
    public Endereco cadastrar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    // Atualizar
    public Endereco atualizar(Integer id, Endereco enderecoNovo) {
        Endereco enderecoExistente = buscarPorId(id);
        if(enderecoExistente == null) {
            return null;
        }
        enderecoExistente.setCep(enderecoNovo.getCep());
        enderecoExistente.setCidade(enderecoNovo.getCidade());
        enderecoExistente.setNumero(enderecoNovo.getNumero());
        enderecoExistente.setLogradouro(enderecoNovo.getLogradouro());
        return enderecoRepository.save(enderecoExistente);
    }

    // Deletar
    public Endereco deletar(Integer id) {
        Endereco enderecoExistente = buscarPorId(id);
        if (enderecoExistente == null) {
            return null;
        }
        enderecoRepository.delete(enderecoExistente);
        return enderecoExistente;
    }
}
