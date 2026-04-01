package com.tjn.estacionamento.controller;

import com.tjn.estacionamento.model.Carro;
import com.tjn.estacionamento.repository.CarroRepository;
import com.tjn.estacionamento.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carro")
public class CarroController {
    private CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Carro> salvar(@RequestBody Carro carro) {
        System.out.println("carro cadastrado"+carro);
        service.cadastrarCarro(carro);
        return ResponseEntity.ok().body(carro);
    }

    @GetMapping
    public List <Carro> listar() {
          return service.listarCarro();
    }

    @DeleteMapping
    public void deletar(@RequestBody Carro carro) {
        service.deletarCarro(carro);
    }
}
