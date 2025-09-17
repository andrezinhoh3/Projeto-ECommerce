package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.Endereco;
import br.com.projeto_senai.entregas.model.Veiculo;
import br.com.projeto_senai.entregas.repository.EnderecoRepository;
import br.com.projeto_senai.entregas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Listar
    public List<Veiculo> listarTodos() {
        return this.veiculoRepository.findAll();
    }

    // Buscar por ID
    public Veiculo buscarPorId(Integer id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    // Cadastrar
    public Veiculo cadastarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Atualizar
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculoNovo) {
        Veiculo veiculoExistente =  buscarPorId(id);
        if (veiculoExistente == null) {
            return null;
        }
        veiculoExistente.setEntregador(veiculoNovo.getEntregador());
        veiculoExistente.setTipo(veiculoNovo.getTipo());
        veiculoExistente.setPlaca(veiculoNovo.getPlaca());
        veiculoExistente.setModelo(veiculoNovo.getModelo());
        return veiculoRepository.save(veiculoExistente);
    }

    // Deletar
    public Veiculo deletar(Integer id) {
        Veiculo veiculoExistente = buscarPorId(id);
        if(veiculoExistente == null) {
            return null;
        }
        veiculoRepository.delete(veiculoExistente);
        return veiculoExistente;
    }
}
