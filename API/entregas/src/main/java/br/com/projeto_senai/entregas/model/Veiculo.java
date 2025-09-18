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
// table - Permite que voce configure a tabela
@Table(name = "veiculo")
public class Veiculo {

    // Id - Define que é uma chave primaria
    @Id
    // Generated Value - define qye a chave é gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    // name - nome da coluna
    // nullable - se pode ser nulo ou nao
    @Column(name = "veiculo_id", nullable = false)
    private Integer veiculoId;

    // definindo para ser TEXT inves de VARCHAR
    @Column(name = "placa", nullable = false, columnDefinition = "TEXT", unique = true)
    private String placa;
    //                                                             para o email ser unico
    @Column(name = "modelo", nullable = false, columnDefinition = "TEXT")
    private String modelo;

    @Column(name = "tipo", nullable = false, columnDefinition = "TEXT")
    private String tipo;


    // Muitos USUARIOS para um TIPO USUARIO
    // Fetch.Type.EAGER - Carrega os dados juntos
    // optional - se é obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // Avisar para o Java, qual a coluna do tipo usuario vou relacionar
    @JoinColumn(name = "entregador_id")
    private Usuario entregador;
}
