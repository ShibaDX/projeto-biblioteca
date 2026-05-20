package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("autores", service.listar());
        return "autor/autorList";
    }

    @GetMapping("/new")
    public String abrirForm(Autor autor, Model model) {
        return "autor/autorForm";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Autor autor, BindingResult result, Model model) {

        // O BindingResult guarda o resultado da validação.
        // Se houver algum erro (ex: nome em branco), ele entra no IF.
        if (result.hasErrors()) {
            // Retorna para a página do formulário sem salvar no banco,
            // mantendo os dados que o usuário já tinha digitado.
            return "autor/autorForm";
        }

        service.salvar(autor);
        return "redirect:/autores";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        var autor = service.buscarPorId(id);
        model.addAttribute("autor", autor);
        return "autor/autorForm";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/autores";
    }
}