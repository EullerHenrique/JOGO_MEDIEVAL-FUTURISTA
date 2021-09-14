package Model.Strategy.Strategy_1_Pulo.Concrete_Strategy_1_Pulo;

import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_1_Pulo.Pulo;

public class Alto extends Pulo {

    public Alto(Personagem personagem) {
        super(personagem);
    }

    public void pular() {
        if(validar()) {
            getPersonagem().getViewPersonagem().DisplayPulo();
        }
    }
}
