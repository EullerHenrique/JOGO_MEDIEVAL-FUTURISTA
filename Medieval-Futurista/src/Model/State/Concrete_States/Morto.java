package Model.State.Concrete_States;


import Model.State.State_Personagem_State.PersonagemState;
import Model.Strategy.Context__Personagem.Personagem;

public class Morto extends PersonagemState {
    public Morto(Personagem personagem) {
        super(personagem);
    }

    public void verificarAlteracaoEstado(){
        if(getPersonagem().getLife() > 0){

            getPersonagem().setPersonagemState(new Fraco(getPersonagem()));
            getPersonagem().getPersonagemState().verificarAlteracaoEstado();
        }
    }
}

