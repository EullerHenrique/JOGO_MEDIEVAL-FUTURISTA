package Model.Strategy.Strategy_1_Pulo;

import Model.Strategy.Context__Personagem.Personagem;

public abstract class Pulo {
    private Personagem personagem;

    public Pulo(Personagem personagem) {
        this.personagem = personagem;
    }

    public Personagem getPersonagem() {
        return personagem;
    }
    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public boolean validar(){
        if(personagem.getLife() > 0) {
            return true;
        }else{
            personagem.getViewPersonagem().DisplayErroMortePulo();
            return false;
        }
    }

    public abstract void pular();


}
