package Model.Strategy.Strategy_3_Ataque;


import Model.Strategy.Context__Personagem.Personagem;

public abstract class Ataque {
    private Personagem atacante;
    private Personagem atacado;
    private int danoTotal;

    private int danoAtaque;

    private int danoGolpeTotal;
    private String golpes = "";

    public Ataque(Personagem atacante) {
        this.atacante = atacante;
    }
    public Ataque() {
    }

    public int getDanoTotal() {
        return danoTotal;
    }
    public void setDanoTotal(int danoTotal) {
        this.danoTotal = danoTotal;
    }

    public Personagem getAtacante() {
        return atacante;
    }
    public void setAtacante(Personagem atacante) {
        this.atacante = atacante;
    }

    public Personagem getAtacado() {
        return atacado;
    }
    public void setAtacado(Personagem atacado) {
        this.atacado = atacado;
    }

    public int getDanoAtaque() {
        return danoAtaque;
    }
    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }



    public int getDanoGolpeTotal() {
        return danoGolpeTotal;
    }
    public void setDanoGolpeTotal(int danoGolpeTotal) {
        this.danoGolpeTotal = danoGolpeTotal;
    }

    public String getGolpes() {
        return golpes;
    }

    public void setGolpes(String golpes) {
        this.golpes = golpes;
    }

    public boolean validar(Personagem atacado) {
        if (atacante.getLife() > 0 && atacado.getLife() > 0 && !atacante.getClass().getSuperclass().getSuperclass().getSimpleName().equals(atacado.getClass().getSuperclass().getSuperclass().getSimpleName())) {
            return true;
        }else if (atacante.getLife() <= 0) {
            atacante.getViewPersonagem().DisplayErroMorteAtaque();
        }else if (atacado.getLife() <= 0) {
            atacado.getViewPersonagem().DisplayErroMorteAtaque();
        }else if(atacante.getClass().getSuperclass().getSuperclass().getSimpleName().equals(atacado.getClass().getSuperclass().getSuperclass().getSimpleName())){
            atacante.getViewPersonagem().DisplayTraicao(atacado);
        }

        return false;
    }

    public abstract void atacar(Personagem atacado);


}
