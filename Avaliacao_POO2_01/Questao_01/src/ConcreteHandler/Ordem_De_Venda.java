package ConcreteHandler;

import Client.Usuario;
import Handler.Mercado_De_Acoes;

public class Ordem_De_Venda extends Mercado_De_Acoes {

    public Ordem_De_Venda(String codigo, int qtd, float preco) {
        super(codigo, qtd, preco);
    }

    public boolean comprar(String codigo, int qtd, float preco, Usuario usuario) {

        if(getCodigo().equals(codigo) && getQtd() >= qtd && getPreco() <= preco){

            usuario.setQtd(usuario.getQtd() + qtd);
            setQtd(getQtd() - qtd);

            return true;//Compra efetuada

        }else{

            if(getSucessor() != null) {
                return getSucessor().comprar(codigo, qtd, preco, usuario);
            }else{
                return false; //Compra recusada
            }
        }

    }

    public String listar_acoes(String acoes) {
        String acao = "";

        if(getQtd() != 0) {
            acao = " Código: " + getCodigo() + " Quantidade: " + getQtd() + " Preço: " + getPreco() + "\n";
        }

        if(getSucessor() != null) {
            return getSucessor().listar_acoes(acoes + acao);
        }else{
            return acoes+ acao;
        }
    }

    public Mercado_De_Acoes ultima_acao(){
        if(getSucessor() == null){
            return this;
        }else{
            return getSucessor().ultima_acao();
        }
    }


}
