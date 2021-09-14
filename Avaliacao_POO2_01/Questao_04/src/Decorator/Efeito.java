package Decorator;

import Component.Forma_Geometrica;

public abstract class Efeito extends Forma_Geometrica {

    public Forma_Geometrica f_g;

    public Efeito(Forma_Geometrica f_g) {
        this.f_g = f_g;
    }

    public abstract void desenhar();
}
