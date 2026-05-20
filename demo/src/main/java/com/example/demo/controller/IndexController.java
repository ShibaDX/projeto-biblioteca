package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("titulo", "Bem-vindo à Biblioteca do Bairro");
        model.addAttribute("texto1", getTexto1());
        return "index";
    }

    private String getTexto1() {
        return """
                Bem-vindo ao sistema da Biblioteca do Bairro, um projeto comunitário que reúne moradores apaixonados por leitura. Nossa plataforma web simples foi criada para facilitar a organização do acervo. Aqui, você pode cadastrar e gerenciar livros e autores, além de encontrar rapidamente qualquer título que deseja.
                """;
    }
}
