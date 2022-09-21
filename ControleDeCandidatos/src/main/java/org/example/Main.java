package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static double salarioBase = 2000.00;
    static int numeroDeVagas = 5;
    static String  [] candidatos = {"FELIPE", "MARCIA","JULIA","PAULO","AUGUSTO", "MONICA","MIRELA","DANIELA","JORGE"};

    public static void main(String[] args) {
        selecionarCandidatos(candidatos, numeroDeVagas);
    }


    static  void selecionarCandidatos(String [] candidatos, int numeroDeVagas){
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        while (candidatoAtual < candidatos.length){
            String nomeCandidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato "+ nomeCandidato + " solicitou um salário de " + salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.println("O Candidato " + nomeCandidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        System.out.println("SALARIO PRETENDIDO: " + salarioPretendido);
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if(salarioBase == salarioPretendido)
        {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else
        {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}