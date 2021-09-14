package Client;

import ConcreteHandler.Ordem_De_Venda;
import Handler.Mercado_De_Acoes;

public class Usuario {

    private int qtd = 1000;
    private Mercado_De_Acoes mercadoDeAcoes;

    public Mercado_De_Acoes getMercadoDeAcoes(){ return mercadoDeAcoes; }

    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }


    public boolean vender(String codigo, int qtd, float preco){

        if(qtd <= getQtd()) {
            Mercado_De_Acoes mercadoDeAcoes = new Ordem_De_Venda(codigo, qtd, preco);

            if (this.mercadoDeAcoes == null) {
                this.mercadoDeAcoes = mercadoDeAcoes;
            } else{
                this.mercadoDeAcoes.ultima_acao().setSucessor(mercadoDeAcoes);
            }
            setQtd(getQtd()-qtd);
            return true;
        }else {
            return false;
        }
    }

    public boolean comprar(String codigo, int qtd, float preco){

        if(mercadoDeAcoes != null) {
            return this.mercadoDeAcoes.comprar(codigo, qtd, preco, this);
        }else{
            return false;
        }

    }

    public String listar_acoes(){

        if(getMercadoDeAcoes() != null) {
            return getMercadoDeAcoes().listar_acoes("");
        }

        return "";
    }


}
