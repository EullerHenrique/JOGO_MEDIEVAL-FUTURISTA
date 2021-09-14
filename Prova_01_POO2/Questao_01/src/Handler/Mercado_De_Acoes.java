package Handler;

import Client.Usuario;

public abstract class Mercado_De_Acoes {

    private Mercado_De_Acoes sucessor;

    private String codigo;
    private int qtd;
    private float preco;

    public Mercado_De_Acoes(String codigo, int qtd, float preco) {
        this.codigo = codigo;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Mercado_De_Acoes getSucessor() {
        return sucessor;
    }
    public void setSucessor(Mercado_De_Acoes sucessor) {
        this.sucessor = sucessor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public int getQtd() {
        return qtd;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float getPreco() {
        return preco;
    }

    public abstract boolean comprar(String codigo, int qtd, float preco, Usuario usuario);
    public abstract String listar_acoes(String acoes);
    public abstract Mercado_De_Acoes ultima_acao();

}
