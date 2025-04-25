package com.bebidas.arueira.controle.repository;

import com.bebidas.arueira.controle.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    List<Ingrediente> findByNomeContainingIgnoreCase(String nome);
    List<Ingrediente> findByQntLessThan(Integer limite);
}
