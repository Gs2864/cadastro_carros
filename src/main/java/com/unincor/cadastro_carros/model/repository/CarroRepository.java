package com.unincor.cadastro_carros.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.unincor.cadastro_carros.model.domain.Carro;

@Repository
public class CarroRepository {

    private final List<Carro> carros = new ArrayList<>();

    public Carro salvar(Carro carro) {
        carros.add(carro);
        return carro;
    }

    public List<Carro> buscarTodos() {
        return List.copyOf(carros);
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carros.stream()
                .filter(carro -> Objects.equals(carro.getId(), id))
                .findFirst();
    }

    public boolean removerPorId(Long id) {
        return carros.removeIf(carro -> Objects.equals(carro.getId(), id));
    }

    public List<Carro> buscarPorAno(Integer ano) {
        return carros.stream()
                .filter(carro -> Objects.equals(carro.getAno(), ano))
                .toList();
    }
}
