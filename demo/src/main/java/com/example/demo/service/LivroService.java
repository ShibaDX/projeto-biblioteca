package com.example.demo.service;

import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro salvar(Livro entity) {
        return repository.save(entity);
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

    public List<Livro> listarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public Livro buscarPorIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }
}
