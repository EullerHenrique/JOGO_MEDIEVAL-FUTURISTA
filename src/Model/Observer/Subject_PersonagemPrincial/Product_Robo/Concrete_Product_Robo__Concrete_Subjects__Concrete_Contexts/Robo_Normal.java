package Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts;


import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Robo;
import Model.State.Concrete_States.Normal;

public class Robo_Normal extends Robo {

    public Robo_Normal(String nome) {
        super(nome);
        setPersonagemState(new Normal(this));
    }

    public void GerarLife() {
        setLife(70 * getLifeMaxima() / 100);
    }



}
