package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroDeVagas = 5;
        double salarioBase = 2000.00;
        boolean encerrar = false;
        ArrayList<Candidato> listaCandidatos = ConectarAoBancoDeCandidatos();
        ArrayList<Candidato> listaSelecionados = FiltrarCandidatos(listaCandidatos, salarioBase, numeroDeVagas);

        Scanner sc = new Scanner(System.in);

        do
        {
            ImprimirSelecao(listaSelecionados);
            System.out.print("\nDigite ID do Candidato que deseja entrar em contato ou 0 (zero) para sair: ");

            try {
                int idParaConsultar = sc.nextInt();
                if(idParaConsultar == 0){
                    encerrar = true;
                }
                else if(idParaConsultar < 0)
                {
                    throw new ExcecaoIdCandidatoIncorreto();
                }
                else{
                    DadosDoCandidato(listaSelecionados, idParaConsultar);
                    System.out.print("\nPressione ENTER para voltar!");
                    sc.nextLine();
                }
            }
            catch (InputMismatchException e){
               e.printStackTrace();
               System.out.print("\nVocê deve inserir apenas números!");
                sc.nextLine();
            }
            catch (ExcecaoIdCandidatoIncorreto idIncorreto){
                System.out.print("\nVocê deve inserir um numero de ID, não negativo, valido!");
                sc.nextLine();
            }

            sc.nextLine();
        }
        while(!encerrar);

        sc.close();
    }

    static ArrayList<Candidato> ConectarAoBancoDeCandidatos(){
        //Simula uma conexão ao bando de dados que retornaria os candidatos
        String  [] nomes = {"FELIPE", "MARCIA","JULIA","PAULO","AUGUSTO", "MONICA","MIRELA","DANIELA","JORGE"};
        ArrayList<Candidato> candidatos  = new ArrayList<Candidato>();

        for (int i = 0; i < nomes.length;i++){
            candidatos.add(new Candidato(i+1, nomes[i]));
        }

        return candidatos;
    }


    static ArrayList<Candidato> FiltrarCandidatos(ArrayList<Candidato> lista, double salarioBase, int numeroDeVagas){
        int candidatosSelecionados = 0;
        ArrayList<Candidato> candidatosQualificados  = new ArrayList<Candidato>();

        for (Candidato c : lista) {
            if (c.pretencaoSalarial <= salarioBase && candidatosSelecionados < numeroDeVagas) {
                candidatosQualificados.add(c);
                candidatosSelecionados++;
            }
        }

        return candidatosQualificados;
    }

    static void ImprimirSelecao(ArrayList<Candidato> lista){
        System.out.print("\n--------\tCandidatos Pre-Selecionados\t---------\n");
        for (Candidato c : lista) {
            System.out.printf("\n-----------------\n\tCandidato: %d\n\tNome: %s\n\tSalario: %.2f\n",c.getId(), c.getNome(),c.getPretencaoSalarial());
        }
    }

    static void DadosDoCandidato(ArrayList<Candidato> lista, int id) throws ExcecaoIdCandidatoIncorreto{
        boolean validID = false;
        for(Candidato c : lista){
            if(id == c.getId()){
                System.out.printf("\n--------\tDetalhes\t---------\n\tCandidato: %d\n\tNome: %s\n\tSalario: %.2f\n\tTelefone: %s\n", c.getId(), c.getNome(),c.getPretencaoSalarial(), c.getTel());
                validID = true;
            }
        }

        if(!validID){
            throw new ExcecaoIdCandidatoIncorreto();
        }
    }
}