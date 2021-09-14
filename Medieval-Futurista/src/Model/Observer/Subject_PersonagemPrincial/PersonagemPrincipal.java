package Model.Observer.Subject_PersonagemPrincial;


import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Strategy.Context__Personagem.Personagem;

import java.util.ArrayList;

public abstract class PersonagemPrincipal extends Personagem {

    private ArrayList<Inimigo> inimigos = new ArrayList<>();

    public PersonagemPrincipal(String nome) {
        super(nome);
    }

    public void registerObserver(Inimigo inimigo){
        inimigos.add(inimigo);
    }

    public void removeObserver(Inimigo inimigo){
        inimigos.remove(inimigo);
    }

    public void notifyObservers(){
        if(getLife() > 0) {
            for (Inimigo inimigo : inimigos) {
                inimigo.update();
            }
        }
    }

}
