package Main;

import Context.Automato_Finito;

public class Main {
    public static void main(String[] args) {

        Automato_Finito automato_finito = new Automato_Finito();

        automato_finito.validar_cadeia("aaacdb");

        automato_finito.validar_cadeia("ababacdaaac");

        automato_finito.validar_cadeia("abcdb");

        automato_finito.validar_cadeia("acda");

        automato_finito.validar_cadeia("acdbdb");


    }
}
