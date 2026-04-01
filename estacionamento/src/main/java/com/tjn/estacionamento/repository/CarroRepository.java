package com.tjn.estacionamento.repository;

import com.tjn.estacionamento.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository  <Carro ,String> {

}
