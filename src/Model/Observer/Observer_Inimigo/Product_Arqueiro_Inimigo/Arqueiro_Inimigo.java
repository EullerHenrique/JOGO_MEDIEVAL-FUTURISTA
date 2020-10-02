package Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo;

import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;

public abstract class Arqueiro_Inimigo extends Inimigo {

    public Arqueiro_Inimigo(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
    }

}
