package com.example.demo.api;

import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/teste")
    public ResponseEntity<>

}
