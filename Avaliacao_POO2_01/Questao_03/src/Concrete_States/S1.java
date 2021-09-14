package Concrete_States;

import Context.Automato_Finito;
import State.Estado;

public class S1 extends Estado {

    public S1(Automato_Finito automato_finito) {
        super(automato_finito);
    }

    public boolean validar_cadeia(){

        String cadeia= this.getAutomato_finito().getCadeia();

        if(cadeia.length() > 0 ) {

            this.show();

            if (cadeia.charAt(0) == 'a') {

                this.getAutomato_finito().setCadeia(cadeia.substring(1));
                this.getAutomato_finito().setEstado(new S2(this.getAutomato_finito()));
                return this.getAutomato_finito().getEstado().validar_cadeia();

            }
        }

        return false;// Cadeia inválida

    }
}
