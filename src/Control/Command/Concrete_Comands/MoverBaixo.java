package Control.Command.Concrete_Comands;


import Control.Command.Command.Comando;
import Model.Strategy.Context__Personagem.Personagem;

public class MoverBaixo extends Comando {

    public MoverBaixo(Personagem personagem) {
        super(personagem);
    }

    public void execute(){
        this.getPersonagem().correr("Baixo");
    }
}
