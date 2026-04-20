package com.tjn.todo.repository;

import com.tjn.todo.modelo.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {
    List<Tarefa> findByData(LocalDate data);
}
