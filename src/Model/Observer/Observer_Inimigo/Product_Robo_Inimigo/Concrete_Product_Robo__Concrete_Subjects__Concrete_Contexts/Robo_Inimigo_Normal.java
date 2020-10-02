package Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts;


import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Robo_Inimigo;
import Model.State.Concrete_States.Normal;
import Model.Strategy.Context__Personagem.Personagem;

public class Robo_Inimigo_Normal extends Robo_Inimigo {

    public Robo_Inimigo_Normal(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
        setPersonagemState(new Normal(this));
    }

    public void GerarLife() {
        setLife(70 * getLifeMaxima() / 100);
    }



}
