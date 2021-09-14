package Leafs;

import Component.Comando;

public class Comando_Simples extends Comando {
    private String nome;

    public Comando_Simples(String nome) {
        this.nome = nome;
    }


    public void execute() {
        System.out.println(this.nome);
    }
}
