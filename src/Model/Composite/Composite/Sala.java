package Model.Composite.Composite;


import Model.Composite.Component.Labirinto;
import Model.Strategy.Context__Personagem.Personagem;
import View.View_Labirinto;

public class Sala extends Labirinto {
    private Labirinto caminho_1;
    private Labirinto caminho_2;
    private Personagem inimigo;

    public Sala(Labirinto caminho_1, Labirinto caminho_2, Personagem inimigo) {
        this.caminho_1 = caminho_1;
        this.caminho_2 = caminho_2;
        this.inimigo = inimigo;
    }


    public void andar(Personagem personagem){

        try{
            Thread.sleep(2000);
        }
        catch(Exception ignored){
        }


        View_Labirinto.sensores(personagem, inimigo, caminho_1, caminho_2);

        double N = Math.random();

        if(N <= 0.2){

            View_Labirinto.inimigo_matou(personagem, inimigo);
            trilhar_caminho(personagem);

        }else if(N <= 0.5){

            View_Labirinto.personagem_fugiu(personagem, inimigo);
            trilhar_caminho(personagem);

        }else if(N <= 1.0){

            View_Labirinto.inimigo_matou(personagem, inimigo);
        }

    }

    public void trilhar_caminho(Personagem personagem){

        double N = Math.random();

        if(N < 0.5 ) {

            View_Labirinto.indo_em_direcao(personagem, caminho_1);
            caminho_1.andar(personagem);
        }else {

            View_Labirinto.indo_em_direcao(personagem, caminho_2);
            caminho_2.andar(personagem);
        }
    }


}
