package com.tjn.estacionamento.service;

import com.tjn.estacionamento.model.Carro;
import com.tjn.estacionamento.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class CarroService {

    private CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public Carro cadastrarCarro(Carro carro){
        carro.setHoraEntrada(LocalDateTime.now());
        return (Carro) repository.save(carro);
    }

    public Double calcularValor(Carro carro){
        Double valorHora=7.0;
        Duration duracao = Duration.between(carro.getHoraEntrada(),LocalDateTime.now());
        Double totalPagar = duracao.toHours() * valorHora;
        System.out.println("Total de pagar: "+totalPagar);
        return totalPagar;
    }

    public  List<Carro> listarCarro(){
        return repository.findAll();
    }

    public void deletarCarro(Carro carro){
        calcularValor(carro);
        repository.delete(carro);
    }




}
