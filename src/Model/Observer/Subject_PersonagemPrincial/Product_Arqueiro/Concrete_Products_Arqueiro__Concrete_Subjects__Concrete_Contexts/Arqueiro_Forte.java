package Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Arqueiro;
import Model.State.Concrete_States.Forte;


public class Arqueiro_Forte extends Arqueiro {

    public Arqueiro_Forte(String nome) {
        super(nome);
        setPersonagemState(new Forte(this));
    }

    public void GerarLife() {
        setLife(100 * getLifeMaxima() / 100);
    }


}
