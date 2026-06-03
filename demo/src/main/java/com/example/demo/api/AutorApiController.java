package com.example.demo.api;

import com.example.demo.model.Autor;
import com.example.demo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorApiController {


    private final AutorService service;

    public AutorApiController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        try {
            var autores = service.listar();

            if (autores.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(autores);

        } catch (Exception e) {
            return ResponseEntity.status(501).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> listar(@PathVariable Long id) {

        var entity = service.buscarPorId(id);

        return ResponseEntity.ok(entity);

    }


    @PostMapping
    public ResponseEntity<Autor> cadastrar(@RequestBody Autor autor) {
        var entity = service.salvar(autor);
        return ResponseEntity.ok(entity);

    }

    @PutMapping
    public ResponseEntity<Autor> alterar(@RequestBody Autor autor) {
        var entity = service.salvar(autor);
        return ResponseEntity.ok(entity);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.ok().build();
    }

}
