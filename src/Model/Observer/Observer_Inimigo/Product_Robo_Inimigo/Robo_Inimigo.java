package Model.Observer.Observer_Inimigo.Product_Robo_Inimigo;

import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;

public abstract class Robo_Inimigo extends Inimigo {

    public Robo_Inimigo(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
    }


}
