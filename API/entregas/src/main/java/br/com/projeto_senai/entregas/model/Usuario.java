package br.com.projeto_senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// Lombok
@Getter
@Setter
// OBRIGATORIO para o JPA funcionar
@NoArgsConstructor
@AllArgsConstructor
// JPA
// Entity - Informa que essa classe é uma tabela
@Entity
// table - Permite que voce configure a tabela
@Table (name = "usuario")
public class Usuario  implements UserDetails {

    // Id - Define que é uma chave primaria
    @Id
    // Generated Value - define qye a chave é gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    // name - nome da coluna
    // nullable - se pode ser nulo ou nao
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

                                      // definindo para ser TEXT inves de VARCHAR
    @Column(name = "nome_completo", nullable = false, columnDefinition = "TEXT")
    private String nomeCompleto;
//                                                             para o email ser unico
    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    // Muitos USUARIOS para um TIPO USUARIO
    // Fetch.Type.EAGER - Carrega os dados juntos
    // optional - se é obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // Avisar para o Java, qual a coluna do tipo usuario vou relacionar
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipoUsuario.getDescricao()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // A conta não expirou?

    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // A conta não está bloqueada?
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // As credenciais não expiraram?
    }

    @Override
    public boolean isEnabled() {
        return true;  // A conta está habilitada?
    }
}
