package com.unincor.cadastro_carros.web;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unincor.cadastro_carros.model.domain.Carro;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final List<Carro> carros = new ArrayList<>();

    private Long proximoId = 1L;

    // POST /carros
    @PostMapping
    public Carro cadastrar(@RequestBody Carro carro) {

        carro.setId(proximoId++);

        carros.add(carro);

        return carro;
    }

    // GET /carros
    @GetMapping
    public List<Carro> listarTodos() {
        return carros;
    }

    // GET /carros/{id}
    @GetMapping("/{id}")
    public Carro buscarPorId(@PathVariable Long id) {

        return carros.stream()
                .filter(carro -> carro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // DELETE /carros/{id}
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {

        boolean removido = carros.removeIf(
                carro -> carro.getId().equals(id)
        );

        if (removido) {
            return "Carro removido com sucesso.";
        }

        return "Carro não encontrado.";
    }

    // GET /carros/ano/{ano}
    @GetMapping("/ano/{ano}")
    public List<Carro> buscarPorAno(@PathVariable Integer ano) {

        return carros.stream()
                .filter(carro -> carro.getAno().equals(ano))
                .toList();
    }

    // GET /carros/novos
    @GetMapping("/novos")
    public List<Carro> listarCarrosNovos() {

        int anoAtual = Year.now().getValue();
        int anoLimite = anoAtual - 5;

        return carros.stream()
                .filter(carro -> carro.getAno() >= anoLimite)
                .toList();
    }
}