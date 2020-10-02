package Control.Command.Concrete_Comands;

import Control.Command.Command.Comando;
import Model.Strategy.Context__Personagem.Personagem;

public class Atacar extends Comando {

    Personagem atacado;

    public Atacar(Personagem atacante, Personagem atacado) {
        super(atacante);
        this.atacado = atacado;
    }

    public void execute() {
        this.getPersonagem().atacar(atacado);
    }
}
