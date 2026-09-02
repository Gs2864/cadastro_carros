package com.unincor.cadastro_carros.web;

import java.time.Year;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unincor.cadastro_carros.model.domain.Carro;
import com.unincor.cadastro_carros.model.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroRepository carroRepository;

    private Long proximoId = 1L;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PostMapping
    public Carro cadastrar(@RequestBody Carro carro) {

        carro.setId(proximoId++);

        return carroRepository.salvar(carro);
    }

    @GetMapping
    public List<Carro> listarTodos() {
        return carroRepository.buscarTodos();
    }

    @GetMapping("/{id}")
    public Carro buscarPorId(@PathVariable Long id) {

        return carroRepository.buscarPorId(id).orElse(null);
    }


    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {

        boolean removido = carroRepository.removerPorId(id);

        if (removido) {
            return "Carro removido com sucesso.";
        }

        return "Carro não encontrado.";
    }

    @GetMapping("/ano/{ano}")
    public List<Carro> buscarPorAno(@PathVariable Integer ano) {

        return carroRepository.buscarPorAno(ano);
    }

    @GetMapping("/novos")
    public List<Carro> listarCarrosNovos() {

        int anoAtual = Year.now().getValue();
        int anoLimite = anoAtual - 5;

        return carroRepository.buscarTodos().stream()
                .filter(carro -> carro.getAno() != null && carro.getAno() >= anoLimite)
                .toList();
    }
}
