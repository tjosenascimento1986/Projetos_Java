package com.tjn.parkcontrol.service;

import com.tjn.parkcontrol.model.Caminhonete;
import com.tjn.parkcontrol.model.Carro;
import com.tjn.parkcontrol.model.Moto;
import com.tjn.parkcontrol.model.Veiculo;
import com.tjn.parkcontrol.repository.RegistroRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    private RegistroRepository repository;

    public RegistroService(RegistroRepository reepository) {
        this.repository = reepository;
    }

    public Veiculo criarObjeto(String tipo){
        Veiculo veiculo = null ;
       if (tipo.equals("Carro")){
           veiculo = new Carro();}
       else if (tipo.equals("Caminhonete")) {
           veiculo = new Caminhonete();
       } else if (tipo.equals("Moto")) {
           veiculo = new Moto();
       }

       return veiculo;
    }

    public Veiculo cadastraEntrada(String tipo){
        Veiculo veiculo = criarObjeto(tipo);

        return veiculo;
    }


}
