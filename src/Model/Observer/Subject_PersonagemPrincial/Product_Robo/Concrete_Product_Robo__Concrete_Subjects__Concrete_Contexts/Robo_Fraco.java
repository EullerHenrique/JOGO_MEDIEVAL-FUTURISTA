package Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts;


import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Robo;
import Model.State.Concrete_States.Fraco;

public class Robo_Fraco extends Robo {

    public Robo_Fraco(String nome) {
        super(nome);
        setPersonagemState(new Fraco(this));
    }

    public void GerarLife() {
      setLife(30 * getLifeMaxima() / 100);
    }


}
