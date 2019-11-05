package br.com.fiap.exerciciofinal.repository;

import br.com.fiap.exerciciofinal.model.Chamado;
import br.com.fiap.exerciciofinal.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    List<Prioridade> findByPrioridade_Codigo(int codigo);
}
