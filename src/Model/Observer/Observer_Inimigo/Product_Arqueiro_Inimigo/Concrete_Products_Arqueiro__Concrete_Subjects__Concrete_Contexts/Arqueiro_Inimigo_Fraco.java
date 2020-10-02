package Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Arqueiro_Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.State.Concrete_States.Fraco;
import Model.Strategy.Context__Personagem.Personagem;


public class Arqueiro_Inimigo_Fraco extends Arqueiro_Inimigo {

    public Arqueiro_Inimigo_Fraco(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
        setPersonagemState(new Fraco(this));
    }

    public void GerarLife() {
      setLife(30 * getLifeMaxima() / 100);
    }


}
