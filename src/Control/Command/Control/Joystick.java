package Control.Command.Control;

import Control.Command.Command.Comando;
import Control.Command.Macro.Macro;

import java.util.ArrayList;

public class Joystick {
    private Macro macroL;
    private Macro macroR;
    private ArrayList<Comando> comando = new ArrayList<Comando>();
    private ArrayList<Comando> log = new ArrayList<Comando>();

    public void setMacroL(Macro macroL){
        this.macroL = macroL;
    }

    public void setMacroR(Macro macroR) {
        this.macroR = macroR;
    }


    public void setCommand(Comando c){
        this.comando.add(c);
    }

    public void pressMacroL(){
        if(macroL!=null) {
            this.macroL.execute();
            log.add(macroL);
        }
    }

    public void pressMacroR(){
        if(macroR!= null) {
            this.macroR.execute();
            log.add(macroR);
        }
    }

    public void press(int i){
        this.comando.get(i).execute();
        log.add(comando.get(i));
    }

    public void execute(Comando c){
        c.execute();
        log.add(c);
    }

    public void showLog(){
        for (Comando c : log) {
            System.out.println(c.toString());
            if(c instanceof Macro){
                ((Macro) c).showLog();
            }
        }
    }

    public void replay(){
        for (Comando c : log) {
            c.execute();
        }
    }

}
