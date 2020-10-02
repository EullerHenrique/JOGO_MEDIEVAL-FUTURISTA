package Control.Jogo_Tematico;

import Control.Jogo;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Factory.Abstract_Factory.Concrete_Factorys.Fabrica_De_Jogo_Futurista;
import View.Audio;


public class Jogo_Futurista extends Jogo {

        public Jogo_Futurista(int construcao_do_personagem) {

            super(construcao_do_personagem);
            fabrica_de_personagem_aleatorio();
            Fabrica_De_Jogo fabrica_de_jogo = Fabrica_De_Jogo_Futurista.getInstance();
            String[] nomes = {"Eva", "Clank", "Bumblebee", "BB-8"};
            fabrica_tematica(fabrica_de_jogo, nomes);
            configs();
            Audio.playSound("src/View/Audios/audio_jogo_futurista.wav");
            setTitle("Jogo Futurista");
        }

    }


