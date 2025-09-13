package br.com.projeto_senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok
@Getter
@Setter
// OBRIGATORIO para o JPA funcionar
@NoArgsConstructor
@AllArgsConstructor
// JPA
// Entity - Informa que essa classe é uma tabela
@Entity
// table - Permite que voce configyre a tabela
@Table (name = "Tipo_usuario")
public class TipoUsuario {

    // Id - Define que é uma chave primaria
    @Id
    // Generated Value - define qye a chave é gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    // name - nome da coluna
    // nullable - se pode ser nulo ou nao
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioId;

                                    // definindo para ser TEXT inves de VARCHAR
    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;
}
