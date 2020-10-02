package Model.Strategy.Strategy_3_Ataque.Product_Arqueiro;

import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;

public abstract class Arma_Do_Arqueiro extends Ataque {

    public Arma_Do_Arqueiro(Personagem atacante) {
        super(atacante);
    }

}
