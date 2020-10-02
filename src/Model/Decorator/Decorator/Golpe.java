package Model.Decorator.Decorator;
import Model.Strategy.Strategy_3_Ataque.Ataque;

public abstract class Golpe extends Ataque {
    private Ataque ataque;
    private int danoGolpe;

    public Golpe(Ataque ataque) {
        this.ataque = ataque;
    }

    public Golpe(){};


    public Ataque getAtaque() {
        return ataque;
    }
    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public int getDanoGolpe() {
        return danoGolpe;
    }
    public void setDanoGolpe(int danoGolpe) {
        this.danoGolpe = danoGolpe;
    }


}
