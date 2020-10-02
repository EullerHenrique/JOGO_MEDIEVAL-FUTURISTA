package Model.State.State_Personagem_State;

import Model.Strategy.Context__Personagem.Personagem;

public abstract class PersonagemState {

    private final Personagem personagem;

    public PersonagemState(Personagem personagem) {
        this.personagem = personagem;
    }


    public Personagem getPersonagem() {
        return personagem;
    }

    public abstract void verificarAlteracaoEstado();

}
