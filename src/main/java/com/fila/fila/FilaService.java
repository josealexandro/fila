package com.fila.fila;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class FilaService {

    private Queue<String> normal = new LinkedList<>();
    private Queue<String> prioridade = new LinkedList<>();

    private int contadorNormal = 1;
    private int contadorPrioridade = 1;

    private int contadorPrioridadeAtendida = 0;

    /* GERAR NORMAL */

    public String gerarNormal() {

        String senha = "N" + String.format("%03d", contadorNormal);

        normal.add(senha);

        contadorNormal++;

        return senha;
    }

    /* GERAR PRIORIDADE */

    public String gerarPrioridade() {

        String senha = "P" + String.format("%03d", contadorPrioridade);

        prioridade.add(senha);

        contadorPrioridade++;

        return senha;
    }

    /* CHAMAR PRÓXIMA */

    public String chamarProxima() {

        if (!prioridade.isEmpty() && contadorPrioridadeAtendida < 2) {

            contadorPrioridadeAtendida++;

            return prioridade.poll();

        } else if (!normal.isEmpty()) {

            contadorPrioridadeAtendida = 0;

            return normal.poll();

        } else if (!prioridade.isEmpty()) {

            contadorPrioridadeAtendida++;

            return prioridade.poll();

        }

        return "---";
    }

    /* VER FILAS */

    public String verFilaNormal() {
        return normal.toString();
    }

    public String verFilaPrioridade() {
        return prioridade.toString();
    }

}