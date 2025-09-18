package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.TipoUsuario;
import br.com.projeto_senai.entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {
    private TipoUsuarioRepository tipoUsuarioRepository;
    public TipoUsuarioService(TipoUsuarioRepository repo) {
        this.tipoUsuarioRepository = repo;
    }

    // Listar
    public List<TipoUsuario> listarTodos () {
        return this.tipoUsuarioRepository.findAll();
    }

    // Buscar por Id
    public TipoUsuario buscarPorId(Integer id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    // Cadastrar
    public TipoUsuario cadastrar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    // Atualizar
    public TipoUsuario atualizar(Integer id, TipoUsuario tUsuarioNovo) {
        TipoUsuario tUsuarioExistente = buscarPorId(id);
        if (tUsuarioExistente == null) {
            return null;
        }

        tUsuarioExistente.setDescricao(tUsuarioNovo.getDescricao());
        return tipoUsuarioRepository.save(tUsuarioExistente);
    }

    // Deletar
    public TipoUsuario deletar(Integer id) {
        TipoUsuario tUsuarioExistente = buscarPorId(id);
        if (tUsuarioExistente == null) {
            return null;
        }
        tipoUsuarioRepository.delete(tUsuarioExistente);
        return tUsuarioExistente;
    }
}
