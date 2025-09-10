package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClienteService  {
    // Injecao de Dependencia
    // Falar que Service depende de alguem
    // Final - constante
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository repo) {
        this.clienteRepository = repo;
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos () {
        return clienteRepository.findAll();
    }

    // Cadastrar
    public Cliente cadastrarCliente(Cliente cl) {
        return clienteRepository.save(cl);
    }

    // Buscar cliente por ID
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Deletar
    public Cliente deletarCliente(Integer id) {
        // 1. Verifico se o Cliente existe
        Cliente cliente = buscarPorId(id);

        // 2. Se nao existir, retorno nulo
        if (cliente == null) {
            return null;
        }

        // 3. Se existir, excluo
        clienteRepository.delete(cliente);
        return cliente;
    }
}
