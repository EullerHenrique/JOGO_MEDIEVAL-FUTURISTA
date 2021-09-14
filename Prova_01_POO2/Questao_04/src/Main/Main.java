package Main;

import Component.Forma_Geometrica;
import Concrete_Component.Quadrado;
import Concrete_Decortators.Luz;
import Concrete_Decortators.Preenchimento;

public class Main {
    public static void main(String[] args) {
        Forma_Geometrica f_g = new Quadrado();
        f_g = new Preenchimento(f_g);
        f_g = new Preenchimento(f_g);

        f_g = new Luz(f_g);
        f_g = new Luz(f_g);
        f_g = new Luz(f_g);
        f_g = new Luz(f_g);

        f_g = new Preenchimento(f_g);
        f_g = new Preenchimento(f_g);
        f_g = new Preenchimento(f_g);
        f_g = new Preenchimento(f_g);

        f_g.desenhar();

    }
}
