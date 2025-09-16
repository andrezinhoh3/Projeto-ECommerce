package br.com.projeto_senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

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
@Table(name = "entrega")
public class Entrega {

    // Id - Define que é uma chave primaria
    @Id
    // Generated Value - define qye a chave é gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    // name - nome da coluna
    // nullable - se pode ser nulo ou nao
    @Column(name = "entrega_id", nullable = false)
    private Integer entregaId;

    // definindo para ser TEXT inves de VARCHAR
    @Column(name = "descricao_produto", nullable = false, columnDefinition = "TEXT")
    private String descricaoProduto;
    //                                                             para o email ser unico
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_pedido", nullable = false)
        private OffsetDateTime dataPedido;
    // Definindo que uma DATA


    // Muitos USUARIOS para um TIPO USUARIO
    // Fetch.Type.EAGER - Carrega os dados juntos
    // optional - se é obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // Avisar para o Java, qual a coluna do tipo usuario vou relacionar
    @JoinColumn(name = "cliente_id")
    private Usuario usuarioId;

    // Muitos USUARIOS para um TIPO USUARIO
    // Fetch.Type.EAGER - Carrega os dados juntos
    // optional - se é obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // Avisar para o Java, qual a coluna do tipo usuario vou relacionar
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
