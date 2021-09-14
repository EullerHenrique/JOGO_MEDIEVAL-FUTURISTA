package Composite;

import Component.Comando;

import java.util.ArrayList;

public class Comando_Composto extends Comando {

    private ArrayList<Comando> comando = new ArrayList<>();

    public void setComando(Comando c) {
        comando.add(c);
    }


    public void execute() {
        for(Comando c: comando){
            c.execute();
        }
    }
}
