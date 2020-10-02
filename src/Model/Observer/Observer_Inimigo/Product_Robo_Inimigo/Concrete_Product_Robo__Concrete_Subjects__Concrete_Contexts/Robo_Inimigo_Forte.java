package Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Robo_Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.State.Concrete_States.Forte;
import Model.Strategy.Context__Personagem.Personagem;


public class Robo_Inimigo_Forte extends Robo_Inimigo {

    public Robo_Inimigo_Forte(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
        setPersonagemState(new Forte(this));
    }


    public void GerarLife() {
        setLife(100 * getLifeMaxima() / 100);
    }




}
