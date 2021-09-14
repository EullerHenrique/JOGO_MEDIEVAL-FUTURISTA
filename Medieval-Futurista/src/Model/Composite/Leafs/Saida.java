package Model.Composite.Leafs;


import Model.Composite.Component.Labirinto;
import Model.Strategy.Context__Personagem.Personagem;
import View.View_Labirinto;

public class Saida extends Labirinto {

    public void andar(Personagem personagem){
        View_Labirinto.saida(personagem);
    }

}
