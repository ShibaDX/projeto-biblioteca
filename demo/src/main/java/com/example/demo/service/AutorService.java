package com.example.demo.service;

import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor salvar(Autor entity) {
        return repository.save(entity);
    }

    public Autor buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public List<Autor> listar() {
        return repository.findAll();
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
