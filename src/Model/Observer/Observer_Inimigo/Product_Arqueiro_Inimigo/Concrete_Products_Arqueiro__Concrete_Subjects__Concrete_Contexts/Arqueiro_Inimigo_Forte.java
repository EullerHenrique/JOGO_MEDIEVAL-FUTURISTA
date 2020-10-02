package Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Concrete_Products_Arqueiro__Concrete_Subjects__Concrete_Contexts;


import Model.Observer.Observer_Inimigo.Product_Arqueiro_Inimigo.Arqueiro_Inimigo;
import Model.State.Concrete_States.Forte;
import Model.Strategy.Context__Personagem.Personagem;

public class Arqueiro_Inimigo_Forte extends Arqueiro_Inimigo {

    public Arqueiro_Inimigo_Forte(Personagem personagemPrincipal, String nome) {
        super(personagemPrincipal, nome);
        setPersonagemState(new Forte(this));
    }

    public void GerarLife() {
        setLife(100 * getLifeMaxima() / 100);
    }


}
