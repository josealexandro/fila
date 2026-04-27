package com.fila.fila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilaController {

    @Autowired
    private FilaService filaService;

    /* ABRIR PÁGINA */

    @GetMapping("/")
    public String pagina() {
        return "index";
    }

    /* GERAR NORMAL */

    @PostMapping("/gerarNormal")
    @ResponseBody
    public String gerarNormal() {

        return filaService.gerarNormal();

    }

    /* GERAR PRIORIDADE */

    @PostMapping("/gerarPrioridade")
    @ResponseBody
    public String gerarPrioridade() {

        return filaService.gerarPrioridade();

    }

    /* CHAMAR */

    @PostMapping("/chamar")
    @ResponseBody
    public String chamar() {

        return filaService.chamarProxima();

    }

    /* VER FILAS */

    @GetMapping("/filaNormal")
    @ResponseBody
    public String filaNormal() {

        return filaService.verFilaNormal();

    }

    @GetMapping("/filaPrioridade")
    @ResponseBody
    public String filaPrioridade() {

        return filaService.verFilaPrioridade();

    }

}