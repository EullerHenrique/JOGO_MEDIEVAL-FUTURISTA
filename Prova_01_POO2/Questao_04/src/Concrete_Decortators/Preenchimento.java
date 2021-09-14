package Concrete_Decortators;

import Component.Forma_Geometrica;
import Decorator.Efeito;

public class Preenchimento extends Efeito {
    public Preenchimento(Forma_Geometrica f_g) {
        super(f_g);
    }

    public void desenhar() {
        f_g.setDescricao(", " + this.getClass().getSimpleName() + getDescricao());
        f_g.desenhar();
    }
}
