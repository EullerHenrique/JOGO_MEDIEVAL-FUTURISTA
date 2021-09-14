package Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Concrete_Product_Robo__Concrete_Subjects__Concrete_Contexts;


import Model.Observer.Observer_Inimigo.Product_Robo_Inimigo.Robo_Inimigo;
import Model.State.Concrete_States.Fraco;
import Model.Strategy.Context__Personagem.Personagem;

public class Robo_Inimigo_Fraco extends Robo_Inimigo {

    public Robo_Inimigo_Fraco(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
        setPersonagemState(new Fraco(this));
    }

    public void GerarLife() {
      setLife(30 * getLifeMaxima() / 100);
    }


}
