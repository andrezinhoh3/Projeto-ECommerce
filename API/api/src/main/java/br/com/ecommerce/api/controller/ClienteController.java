package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ANOTACOES
// É um pedido e resposta
@RestController
// Criando um link pro front-end se conectar ao back-end
@RequestMapping("/api/clientes")

// INJECAO DE DEPENDENCIA
public class ClienteController {
    // Controller -> Service
    private final ClienteService clienteService;
    public ClienteController(ClienteService service) {
        this.clienteService = service;
    }

    // Lista Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        // 1. Pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    //Cadastrar
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente clienteNovo) {
        // 1. Tentar cadastrar o cliente
        clienteService.cadastrarCliente(clienteNovo);

        // Codigo 200 - OK
        //  return ResponseEntity.ok(clienteNovo);
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
    }
}
