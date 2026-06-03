package com.example.demo.api;

import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroApiController {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> listar(){

        var livros = service.listar();

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> listar(@PathVariable Long id) {
        var entity = service.buscarPorId(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro){
        var entity = service.salvar(livro);
        return ResponseEntity.ok(entity);
    }

    @PutMapping
    public ResponseEntity<Livro> alterar(@RequestBody Livro livro){
        var entity = service.salvar(livro);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.ok().build();
    }


}
