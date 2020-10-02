package Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Arqueiro;
import Model.State.Concrete_States.Fraco;


public class Arqueiro_Fraco extends Arqueiro {

    public Arqueiro_Fraco(String nome) {
        super(nome);
        setPersonagemState(new Fraco(this));
    }

    public void GerarLife() {
      setLife(30 * getLifeMaxima() / 100);
    }


}
