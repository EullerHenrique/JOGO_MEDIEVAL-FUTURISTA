package Concrete_Decortators;

import Component.Forma_Geometrica;
import Decorator.Efeito;

public class Luz extends Efeito {
    public Luz(Forma_Geometrica f_g) {
        super(f_g);
    }

    public void desenhar() {
        f_g.setDescricao(", " + this.getClass().getSimpleName() + getDescricao());
        f_g.desenhar();
    }
}
