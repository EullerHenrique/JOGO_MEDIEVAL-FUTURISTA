package Client;

import Composite.Comando_Composto;
import Leafs.Comando_Condicional;
import Leafs.Comando_Simples;

public class Main {

    public static void main(String[] args) {
        Comando_Simples comando_simples_1 = new Comando_Simples("printf()");
        Comando_Simples comando_simples_2 = new Comando_Simples("scanf()");

        Comando_Simples comando_simples_3 = new Comando_Simples("execute()");
        Comando_Simples comando_simples_4 = new Comando_Simples("stop()");

        Comando_Condicional comando_condicional_1 = new Comando_Condicional(comando_simples_1, comando_simples_2);
        Comando_Condicional comando_condicional_2 = new Comando_Condicional(comando_simples_3, comando_simples_4);

        Comando_Composto comando_composto = new Comando_Composto();

        comando_composto.setComando(comando_condicional_1);
        comando_composto.setComando(comando_condicional_2);

        Comando_Condicional comando_condicional_3 = new Comando_Condicional(comando_simples_3, comando_composto);

        comando_composto.setComando(comando_condicional_3);

        comando_composto.setComando(comando_simples_4);

        comando_composto.execute();



    }
}
