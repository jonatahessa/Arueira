package com.bebidas.arueira.controle.service;

import com.bebidas.arueira.controle.domain.Ingrediente;
import com.bebidas.arueira.controle.domain.enums.TipoQnt;
import com.bebidas.arueira.controle.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Transactional
    public Ingrediente criarIngrediente(String nome, TipoQnt tipoQnt, Integer qnt, BigDecimal preco) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(nome);
        ingrediente.setTipoQnt(tipoQnt);
        ingrediente.setQnt(qnt);
        ingrediente.setPreco(preco);

        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> listarTodosIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> buscarIngredientePorId(Integer id) {
        return ingredienteRepository.findById(id);
    }

    @Transactional
    public Ingrediente atualizarIngrediente(Integer id, String nome, TipoQnt tipoQnt, Integer qnt, BigDecimal preco) {
        Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);

        if (ingredienteOptional.isPresent()) {
            Ingrediente ingrediente = ingredienteOptional.get();
            if (nome != null) ingrediente.setNome(nome);
            if (tipoQnt != null) ingrediente.setTipoQnt(tipoQnt);
            if (qnt != null) ingrediente.setQnt(qnt);
            if (preco != null) ingrediente.setPreco(preco);

            return ingredienteRepository.save(ingrediente);
        }

        return null;
    }

    @Transactional
    public boolean deletarIngrediente(Integer id) {
        Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);

        if (ingredienteOptional.isPresent()) {
            ingredienteRepository.delete(ingredienteOptional.get());
            return true;
        }

        return false;
    }

    // Métodos adicionais úteis para controle de estoque
    public List<Ingrediente> buscarIngredientesPorNome(String nome) {
        return ingredienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Ingrediente> buscarIngredientesComEstoqueBaixo(Integer limite) {
        return ingredienteRepository.findByQntLessThan(limite);
    }

    @Transactional
    public Ingrediente ajustarEstoque(Integer id, Integer quantidade) {
        Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);

        if (ingredienteOptional.isPresent()) {
            Ingrediente ingrediente = ingredienteOptional.get();
            ingrediente.setQnt(ingrediente.getQnt() + quantidade);
            return ingredienteRepository.save(ingrediente);
        }

        return null;
    }
}