package com.tjn.todo.service;

import com.tjn.todo.modelo.Tarefa;
import com.tjn.todo.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;
    }

    public List<Tarefa> listarTodas(){
        return repository.findAll();
    }

    public List<Tarefa> listarPorHoje(){
        LocalDate hoje = LocalDate.now();
        return repository.findByData(hoje);
    }

    public Tarefa salvarTarefa(Tarefa tarefa){
        tarefa.setData(LocalDate.now());
        return repository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Tarefa tarefa){
        tarefa.setData(LocalDate.now());
        return repository.save(tarefa);
    }

    public void excluirTarefa(long id){
        repository.deleteById((int) id);
    }

    // ✅ CORRETO AGORA (usa ID)
    public Tarefa concluir(long id){
        Tarefa tarefa = repository.findById((int) id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.concluir(); // alterna true/false
        return repository.save(tarefa);
    }
}