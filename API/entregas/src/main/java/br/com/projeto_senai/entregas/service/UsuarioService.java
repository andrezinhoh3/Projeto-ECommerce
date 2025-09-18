package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.Usuario;
import br.com.projeto_senai.entregas.repository.UsuarioRepository;

import java.util.List;
public class UsuarioService {
    public UsuarioService(UsuarioRepository repo ) {
    }

    // Listar
    public List<Usuario> listarTodos() {
    }

    // Buscar por Id
    public Usuario buscarPorId(Integer id) {
    }

    // Cadastrar
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
    }

    // Deletar
    public Usuario deletar(Integer id) {
        Usuario usuarioExistente = buscarPorId(id);
        if (usuarioExistente == null) {
            return null;
        }
        return usuarioExistente;
    }
}

