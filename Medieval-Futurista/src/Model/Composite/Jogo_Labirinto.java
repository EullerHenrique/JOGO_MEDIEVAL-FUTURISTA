package Model.Composite;


import Model.Composite.Component.Labirinto;
import Model.Strategy.Context__Personagem.Personagem;

public class Jogo_Labirinto implements Runnable{

    private Labirinto labirinto;
    private Personagem personagem;

    public Jogo_Labirinto(Labirinto labirinto, Personagem personagem){
        this.labirinto = labirinto;
        this.personagem = personagem;
    }


    public void run(){

        labirinto.andar(personagem);

    }
}