package Component;

public abstract class Forma_Geometrica {

    private String descricao = "";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract void desenhar();
}
