package com.tjn.todo.controller;

import com.tjn.todo.modelo.Tarefa;
import com.tjn.todo.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service){
        this.service = service;
    }

    @GetMapping("/listartodos")
    public List<Tarefa> listarTodas(){
        return service.listarTodas();
    }

    @GetMapping("/listarhoje")
    public List<Tarefa> listarPorHoje(){
        return service.listarPorHoje();
    }

    @PostMapping("/salvartarefa")
    public Tarefa salvarTarefa(@RequestBody Tarefa tarefa){
        return service.salvarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable long id, @RequestBody Tarefa tarefa){
        tarefa.setId(id);
        return service.atualizarTarefa(tarefa);
    }

    @DeleteMapping("/{id}")
    public void excluirTarefa(@PathVariable long id){
        service.excluirTarefa(id);
    }

    // ✅ CORRETO AGORA
    @PutMapping("/{id}/concluir")
    public Tarefa concluirTarefa(@PathVariable long id){
        return service.concluir(id);
    }


}