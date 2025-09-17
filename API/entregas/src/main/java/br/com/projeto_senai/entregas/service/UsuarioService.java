package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.Usuario;
import br.com.projeto_senai.entregas.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usarioRepository;
    public UsuarioService(UsuarioRepository repo ) {
        this.usarioRepository = repo;
    }

    // Listar
    public List<Usuario> listarTodos() {
        return this.usarioRepository.findAll();
    }

    // Buscar por Id
    public Usuario buscarPorId(Integer id) {
        return usarioRepository.findById(id).orElse(null);
    }

    // Cadastrar
    public Usuario cadastrar(Usuario usuario) {
        return usarioRepository.save(usuario);
    }

    // Atualizar
    public Usuario atualizar(Integer id, Usuario usuarioNovo) {
        Usuario usuarioExistente = buscarPorId(id);
        if (usuarioExistente == null) {
            return null;
        }
        usuarioExistente.setTipoUsuario(usuarioNovo.getTipoUsuario());
        usuarioExistente.setNomeCompleto(usuarioNovo.getNomeCompleto());
        usuarioExistente.setEmail(usuarioNovo.getEmail());
        usuarioExistente.setSenha(usuarioNovo.getSenha());
        return usarioRepository.save(usuarioExistente);
    }

    // Deletar
    public Usuario deletar(Integer id) {
        Usuario usuarioExistente = buscarPorId(id);
        if (usuarioExistente == null) {
            return null;
        }
        usarioRepository.delete(usuarioExistente);
        return usuarioExistente;
    }
}

