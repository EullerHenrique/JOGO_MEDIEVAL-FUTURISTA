package Template_Method;

import java.util.Random;

public abstract class Banco {

    protected String nome;
    protected String senha;
    protected double valor;

    public final void criarConta(){
        cadastrarPessoaFisica();
        if(validarPessoaFisicaSPC()) {
            depositarValorInicial();
            configurarLimite();
            cadastrarSenha();
            if(perguntarSeClienteQuerCartao()){
                solicitarCartaoCredito();
            }
            finalizar();
        }
    }


    protected final void cadastrarPessoaFisica(){

        String[] nomes = {"João", "Maria", "José", "Joaquim", "Joaquina", "Euller"};

        int i = new Random().nextInt(nomes.length);

        this.nome = nomes[i];

        System.out.println(nome + ", seus dados foram cadastrados com sucesso! ");
    }
    protected final boolean validarPessoaFisicaSPC(){
        double N = Math.random();

        if(N < 0.5){
            System.out.println(nome + ", parabéns, seu nome não está no SPC, já já iremos finalizar a criação da sua conta");
            return true;
        }else{
            System.out.println(nome + ", seu nome está no SPC, então infelizmente não podemos aceitar a criação da sua conta :( \n");
            return false;
        }

    }
    protected abstract void  depositarValorInicial();
    protected void configurarLimite(){}//Hook
    protected final void cadastrarSenha(){
        String[] senhas = {"OIOIOI", "HELLOHELLO", "SENHA","12345", "PASSWORD", "HIHIHI"};

        int i = new Random().nextInt(senhas.length);

        this.senha = senhas[i];

        System.out.println(nome+", sua senha ("+senha+") foi cadastrada com sucesso! ");
    }
    protected boolean perguntarSeClienteQuerCartao(){ return false;}//Hook
    protected void solicitarCartaoCredito(){}//Hook
    protected abstract void finalizar();

}
