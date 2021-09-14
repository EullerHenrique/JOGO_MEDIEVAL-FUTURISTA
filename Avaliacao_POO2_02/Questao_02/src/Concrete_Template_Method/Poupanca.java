package Concrete_Template_Method;

import Template_Method.Banco;

import java.util.Random;

public class Poupanca extends Banco {


    protected void depositarValorInicial() {
        Double[] valores = {123.99,1234.5, 135.65, 3452.13, 1234.21, 5000.50};

        int i = new Random().nextInt(valores.length);
        valor = valores[i];
        System.out.println(nome+", seu depósito inicial de R$: " + valor + " foi feito com sucesso na sua conta poupança");
    }

    protected void finalizar() {
        System.out.println(nome+", sua conta poupança foi criada com sucesso\n");
    }
}
