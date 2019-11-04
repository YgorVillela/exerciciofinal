package br.com.fiap.exerciciofinal.repository;

import br.com.fiap.exerciciofinal.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrioridadeRepository extends JpaRepository<Prioridade,Integer> {

    List<Prioridade> findByNivel(int buscaPorNivel);
}
