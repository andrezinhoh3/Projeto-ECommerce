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

    // Buscar cliente por ID
    @GetMapping("/{id}")
    // Path Variable -> Recebe um valor no link
    // Request Body -> Recebe dados pelo corpo
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        // 1. Procurar e guardar o Cliente
        Cliente cliente = clienteService.buscarPorId(id);


        // 2. Se nao encontrar, retorno um erro
        if (cliente == null) {
            // Mais simples
            //  return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");
        }

        // 3. Se encontrar, retorno o Cliente
        return ResponseEntity.ok(cliente);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
        // 1. Verifico se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);

        // 2. Se nao existir retorno erro
        if(cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");
        }

        // 3. Se existir, retorno ok
        return ResponseEntity.ok(cliente);
    }

}
