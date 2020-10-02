package Model.Strategy.Strategy_3_Ataque.Product_Robo;

import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;

public abstract class Arma_Do_Robo extends Ataque {

    public Arma_Do_Robo(Personagem atacante) {
        super(atacante);
    }

}
