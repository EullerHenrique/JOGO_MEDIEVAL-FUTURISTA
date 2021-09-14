package Leafs;

import Component.Comando;

public class Comando_Condicional extends Comando{
    Comando comando_1;
    Comando comando_2;

    public Comando_Condicional(Comando comando_1, Comando comando_2) {
        this.comando_1 = comando_1;
        this.comando_2 = comando_2;
    }

    public void execute(){
        double N = Math.random();
        if(N < 0.5){
            System.out.println("1");
            comando_1.execute();
        }else{
            System.out.println("2");
            comando_2.execute();
        }
    }
}
