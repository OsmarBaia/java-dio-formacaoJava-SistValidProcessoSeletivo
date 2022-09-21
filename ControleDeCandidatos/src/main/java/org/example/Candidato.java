package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Candidato {
    private int id;
    private String nome;
    private String tel;
    double pretencaoSalarial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getPretencaoSalarial() {
        return pretencaoSalarial;
    }

    public void setPretencaoSalarial(double pretencaoSalarial) {
        this.pretencaoSalarial = pretencaoSalarial;
    }


    public Candidato(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.tel = fakeTelContato();
        this.pretencaoSalarial = fakeSalarioPretendido();
    }


    String fakeTelContato(){
        StringBuilder sb = new StringBuilder();
        sb.append('3');
        for (int i = 0; i < 7; i++) {
            sb.append(Math.round(Math.random()*10));
        }
        return sb.toString();
    }

    double fakeSalarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

}
