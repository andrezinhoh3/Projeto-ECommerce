package br.com.projeto_senai.entregas.repository;

import br.com.projeto_senai.entregas.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    // Método personalizado para buscar um veiculo pela placa
    Optional<Veiculo> findByPlaca(String placa);
}
