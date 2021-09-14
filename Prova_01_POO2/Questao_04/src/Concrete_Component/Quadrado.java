package Concrete_Component;

import Component.Forma_Geometrica;

public class Quadrado extends Forma_Geometrica {

    public void desenhar() {
        setDescricao(this.getClass().getSimpleName() +getDescricao());
        System.out.println(getDescricao());
    }

}

