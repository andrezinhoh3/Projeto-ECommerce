package br.com.projeto_senai.entregas.service;

import br.com.projeto_senai.entregas.model.Usuario;
import br.com.projeto_senai.entregas.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;
    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = repo;
        this.passwordEncoder = passwordEncoder;
    }

    // Listar
    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    // Buscar por ID
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Cadastrar
    public Usuario cadastrarUsuario(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());

        // Substitui a senha original pelo hash gerado
        usuario.setSenha(senhaCriptografada);

        // Salva o usuário no banco com a senha já em formato de hash
        return usuarioRepository.save(usuario);
    }

    // Atualizar
    public Usuario atualizarUsuario(Integer id, Usuario usuarioNovo) {
        Usuario usuarioExistente = buscarPorId(id);
        if (usuarioExistente == null) {
            return null;
        }
        usuarioExistente.setNomeCompleto(usuarioNovo.getNomeCompleto());
        usuarioExistente.setEmail(usuarioNovo.getEmail());
        usuarioExistente.setSenha(usuarioNovo.getSenha());
        return usuarioRepository.save(usuarioExistente);
    }

    // Deletar
    public Usuario deletar(Integer id) {
        Usuario usuarioExistente = buscarPorId(id);
        if (usuarioExistente == null) {
            return null;
        }
        usuarioRepository.delete(usuarioExistente);
        return usuarioExistente;
    }

    // Esse método recebe o ID do usuario a ser nydadi e um objeto 'uNovo'
    // com as informacoes novas que vieram da sua API
    public Usuario atualizar(Integer id, Usuario uNovo) {
        // 1. Buscamos a versao ATUAL do usuario que esta no banco de dados.
        // Não podemos trabalhar em cima dos dados que vieram da API diretamete.
        // Precisamos primeiro pegar o "original" do banco
        Usuario uExistente = buscarPorId(id);

        // Atualizando ...
        uExistente.setNomeCompleto(uNovo.getNomeCompleto());
        uExistente.setEmail(uNovo.getEmail());
        return usuarioRepository.save(uNovo);
    }
}
