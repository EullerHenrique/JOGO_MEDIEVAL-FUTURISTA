package Client;

import Concrete_Template_Method.Corrente;
import Concrete_Template_Method.Poupanca;
import Template_Method.Banco;

public class Main {

    public static void main(String[] args) {

        Banco poupanca = new Poupanca();
        poupanca.criarConta();

        Banco corrente = new Corrente();
        corrente.criarConta();

    }

}
