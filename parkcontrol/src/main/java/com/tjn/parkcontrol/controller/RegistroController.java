package com.tjn.parkcontrol.controller;

import com.tjn.parkcontrol.repository.RegistroRepository;
import com.tjn.parkcontrol.service.RegistroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carro")

public class RegistroController {

    private RegistroService registroService;
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }



    @PostMapping
    public void cadastrarEntrada(@RequestBody String tipo){

    }
    public void finalizarEstadia(){

    }
    public void buscarVeiculo(){

    }
}
