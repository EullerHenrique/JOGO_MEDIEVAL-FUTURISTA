package Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Arqueiro;
import Model.State.Concrete_States.Normal;

public class Arqueiro_Normal extends Arqueiro {

    public Arqueiro_Normal(String nome) {
        super(nome);
        setPersonagemState(new Normal(this));
    }

    public void GerarLife() {
        setLife(70 * getLifeMaxima() / 100);
    }



}
