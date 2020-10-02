package Model.Chain_Of_Responsability.Handler;
import Model.Strategy.Context__Personagem.Personagem;


public abstract class Escudo {

    private Escudo sucessor;
    private int lifeEscudo;
    private int lifeEscudoTotal;
    private int lifeEscudoTotalFinal;
    private String escudos = "";

    public Escudo getSucessor() {
        return sucessor;
    }
    public void setSucessor(Escudo sucessor) {
        this.sucessor = sucessor;
    }

    public int getLifeEscudo() {
        return lifeEscudo;
    }
    public void setLifeEscudo(int lifeEscudo) {
        this.lifeEscudo = lifeEscudo;
    }

    public int getLifeEscudoTotal() {
        return lifeEscudoTotal;
    }
    public void setLifeEscudoTotal(int lifeEscudoTotal) {
        this.lifeEscudoTotal = lifeEscudoTotal;
    }

    public int getLifeEscudoTotalFinal() {
        return lifeEscudoTotalFinal;
    }
    public void setLifeEscudoTotalFinal(int lifeEscudoTotalFinal) {
        this.lifeEscudoTotalFinal = lifeEscudoTotalFinal;
    }

    public String getEscudos() {
        return escudos;
    }
    public void setEscudos(String escudos) {
        this.escudos = escudos;
    }

    public abstract void atacar(Personagem atacante, Personagem atacado);



}
