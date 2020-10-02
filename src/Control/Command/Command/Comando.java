package Control.Command.Command;

import Model.Strategy.Context__Personagem.Personagem;

public abstract class Comando {

    private Personagem personagem;

    public Comando(Personagem personagem) {
        this.personagem = personagem;
    }

    public Comando(){

    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public abstract void execute();

}
