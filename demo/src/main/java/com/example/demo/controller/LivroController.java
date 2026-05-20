package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import com.example.demo.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {


    @Autowired
    private LivroService service;

    @Autowired
    private AutorService autorService;

    @GetMapping
    public String listar(@RequestParam(value = "titulo", required = false) String titulo, Model model) {

        // verifica se o campo está preenchido
        if (titulo != null && !titulo.trim().isEmpty()) {
            model.addAttribute("livros", service.listarPorTitulo(titulo));
            model.addAttribute("tituloPesquisado", titulo); // mantém o texto no input de busca após a página recarregar
        } else {
            // senão, traz a listagem completa
            model.addAttribute("livros", service.listar());
        }

        return "livro/livroList";
    }

    @GetMapping("/new")
    public String abrirForm(Livro livro, Model model) {
        // envia uma lista de autores para popular o <select> no form
        model.addAttribute("autores", autorService.listar());
        return "livro/livroForm";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Livro livro, BindingResult result, Model model) {

        Livro livroExistente = service.buscarPorIsbn(livro.getIsbn());

        if (livroExistente != null && !livroExistente.getId().equals(livro.getId())) {

            // Rejeita o valor do campo "isbn" e cria uma mensagem de erro na hora
            result.rejectValue("isbn", "error.livro", "Este ISBN já está cadastrado no sistema.");
        }

        // O BindingResult guarda o resultado da validação.
        // Se houver algum erro (ex: nome em branco), ele entra no IF.
        if (result.hasErrors()) {
            // Retorna para a página do formulário sem salvar no banco,
            // mantendo os dados que o usuário já tinha digitado.
            model.addAttribute("autores", autorService.listar());

            return "livro/livroForm";
        }

        service.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        var livro = service.buscarPorId(id);
        model.addAttribute("livro", livro);

        // envia uma lista de autores para popular o <select> no form
        model.addAttribute("autores", autorService.listar());

        return "livro/livroForm";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/livros";
    }

}