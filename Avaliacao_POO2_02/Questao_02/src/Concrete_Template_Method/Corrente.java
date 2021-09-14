package Concrete_Template_Method;

import Template_Method.Banco;

import java.util.Random;

public class Corrente extends Banco {

    private double limite;

    protected void depositarValorInicial() {
        Double[] valores = {1233.99,12344.5, 1355.65, 34522.13, 12344.21, 50000.50};

        int i = new Random().nextInt(valores.length);
        valor = valores[i];
        System.out.println(nome+", seu depósito inicial de R$: " + valor + " foi feito com sucesso na sua conta corrente");
    }

    protected void configurarLimite(){//Hook

        this.limite = valor * 2;
        System.out.println(nome + ", seu limite é "+limite);

    }

    protected boolean perguntarSeClienteQuerCartao(){//Hook
        double N = Math.random();

        if(N < 0.5){
            System.out.println(nome +", irei solicitar seu cartão");
            return true;
        }else{
            System.out.println(nome + ", quando você desejar solicitar seu cartão, ligue pra gente");
            return false;
        }
    }

    protected void solicitarCartaoCredito(){

        System.out.println(nome + ", seu cartão de crédito foi solicitado");
    }


    protected void finalizar() {
        System.out.println(nome+", sua conta corrente foi criada com sucesso\n");
    }


}
