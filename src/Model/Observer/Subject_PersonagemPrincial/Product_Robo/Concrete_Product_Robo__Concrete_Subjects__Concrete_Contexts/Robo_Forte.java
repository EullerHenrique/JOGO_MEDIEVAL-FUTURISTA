package Model.Observer.Subject_PersonagemPrincial.Product_Robo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts;

import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Robo;
import Model.State.Concrete_States.Forte;


public class Robo_Forte extends Robo {

    public Robo_Forte(String nome) {
        super(nome);
        setPersonagemState(new Forte(this));
    }

    public void GerarLife() {
        setLife(100 * getLifeMaxima() / 100);
    }




}
