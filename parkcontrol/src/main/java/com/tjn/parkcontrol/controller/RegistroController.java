package com.tjn.parkcontrol.controller;

import com.tjn.parkcontrol.repository.RegistroRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carro")
public class RegistroController {

    private RegistroRepository registroRepository;
    public RegistroController(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    @PostMapping
    public void cadastrarEntrada(@RequestBody String placa){

    }
    public void finalizarEstadia(){

    }
    public void buscarVeiculo(){

    }
}
