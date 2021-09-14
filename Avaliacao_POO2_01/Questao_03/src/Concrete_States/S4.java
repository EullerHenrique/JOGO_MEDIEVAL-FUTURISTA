package Concrete_States;

import Context.Automato_Finito;
import State.Estado;

public class S4 extends Estado {


    public S4(Automato_Finito automato_finito) {
        super(automato_finito);
        System.out.println("S4\n");
    }


    public boolean validar_cadeia(){

            String cadeia = this.getAutomato_finito().getCadeia();

            if(cadeia.length() > 0 ) {

                this.show();

                if (cadeia.charAt(0) == 'd') {

                    this.getAutomato_finito().setCadeia(cadeia.substring(1));
                    this.getAutomato_finito().setEstado(new S3(this.getAutomato_finito()));
                    return this.getAutomato_finito().getEstado().validar_cadeia();

                }
            }

            return true; // Cadeia válida

        }

    }
