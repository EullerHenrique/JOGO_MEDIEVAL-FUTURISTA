package Control.Jogo_Tematico;


import Control.Jogo;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Factory.Abstract_Factory.Concrete_Factorys.Fabrica_De_Jogo_Medieval;
import View.Audio;


public class Jogo_Medieval extends Jogo {

    public Jogo_Medieval(int construcao_do_personagem){
        super(construcao_do_personagem);
        fabrica_de_personagem_aleatorio();
        Fabrica_De_Jogo fabrica_de_jogo = Fabrica_De_Jogo_Medieval.getInstance();
        String[] nomes = {"Atreus", "Ezio", "Link", "Merida"};
        fabrica_tematica(fabrica_de_jogo, nomes);
        configs();
        Audio.playSound("src/View/Audios/audio_jogo_medieval.wav");
        setTitle("Jogo Medieval");
    }

}

