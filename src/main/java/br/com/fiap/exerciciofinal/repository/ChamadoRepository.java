package br.com.fiap.exerciciofinal.repository;

import br.com.fiap.exerciciofinal.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
