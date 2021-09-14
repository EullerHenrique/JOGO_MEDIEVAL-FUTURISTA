package Control.Command.Concrete_Comands;


import Control.Command.Command.Comando;
import Model.Strategy.Context__Personagem.Personagem;

public class Pular extends Comando {

    public Pular(Personagem personagem) {
        super(personagem);
    }

    public void execute(){
        this.getPersonagem().pular();
    }
}
