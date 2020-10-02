package Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Arqueiro_Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.State.Concrete_States.Normal;
import Model.Strategy.Context__Personagem.Personagem;

public class Arqueiro_Inimigo_Normal extends Arqueiro_Inimigo {

    public Arqueiro_Inimigo_Normal(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
        setPersonagemState(new Normal(this));
    }

    public void GerarLife() {
        setLife(70 * getLifeMaxima() / 100);
    }



}
