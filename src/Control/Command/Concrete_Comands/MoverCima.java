package Control.Command.Concrete_Comands;

import Control.Command.Command.Comando;
import Model.Strategy.Context__Personagem.Personagem;

public class MoverCima extends Comando {


    public MoverCima(Personagem personagem) {
        super(personagem);
    }

    public void execute(){
        this.getPersonagem().correr("Cima");
    }
}
