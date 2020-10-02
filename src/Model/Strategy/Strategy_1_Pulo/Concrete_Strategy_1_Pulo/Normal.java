package Model.Strategy.Concrete_Strategy_1_Pulo;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_1_Pulo.Pulo;

public class Normal extends Pulo {

    public Normal(Personagem personagem) {
        super(personagem);
    }

    public void pular() {
        if(validar()) {
            getPersonagem().getViewPersonagem().DisplayPulo();
        }
    }
}
