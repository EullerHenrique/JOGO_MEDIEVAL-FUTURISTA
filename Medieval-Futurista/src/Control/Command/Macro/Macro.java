package Control.Command.Macro;


import Control.Command.Command.Comando;

import java.util.ArrayList;

public class Macro extends Comando {

    private ArrayList<Comando> macro = new ArrayList<Comando>();
    private ArrayList<Comando> log = new ArrayList<Comando>();

    public void add(Comando c){
        macro.add(c);
    }

    public void remove(Comando c){
        macro.remove(c);
    }

    public void execute(){
        for(Comando c: macro){
            c.execute();
            log.add(c);
        }
    }

    public void showLog(){
        for (Comando c : log) {
            System.out.println(c.toString());
        }
        System.out.println("\n");
    }


}
