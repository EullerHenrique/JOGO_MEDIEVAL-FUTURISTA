package Model.Composite.Simple_Factory;

import Model.Composite.Component.Labirinto;
import Model.Composite.Composite.Sala;
import Model.Composite.Jogo_Labirinto;
import Model.Composite.Leafs.Abismo;
import Model.Composite.Leafs.Saida;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Factory.Abstract_Factory.Concrete_Factorys.Fabrica_De_Jogo_Futurista;
import Model.Factory.Abstract_Factory.Concrete_Factorys.Fabrica_De_Jogo_Medieval;
import Model.Factory.Factory_Method.Concrete_Creators__Simple_Factorys.Fabrica_Avancada_De_Personagem_Aleatorio;
import Model.Factory.Factory_Method.Concrete_Creators__Simple_Factorys.Fabrica_Simples_De_Personagem_Aleatorio;
import Model.Factory.Factory_Method.Creator.Fabrica_De_Personagem_Aleatorio;
import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Strategy.Context__Personagem.Personagem;

public class Fabrica_Do_Jogo_De_Labirinto {

    public static Labirinto criaLabirinto(Personagem inimigo){
        Labirinto sala1 = criaCaminho();
        Labirinto sala2 = criaCaminho();
        Labirinto sala3 = new Sala(sala1, sala2, inimigo);
        Labirinto labirinto = new Sala(sala1, sala3, inimigo);

        double N = Math.random();

        if(N <= 0.1){
            labirinto = new Sala(sala1, sala2, inimigo);
        } else if(N <= 0.2) {
            labirinto = new Sala(sala1, sala3, inimigo);
        } else if(N <= 0.3) {
            labirinto = new Sala(sala3, sala3, inimigo);
        }else if(N <= 0.4){
            labirinto = new Sala(sala1, labirinto, inimigo);
        }else if(N <= 0.5){
            labirinto = new Sala(labirinto, sala1, inimigo);
        }else if(N <= 0.6){
            labirinto = new Sala(sala2, labirinto, inimigo);
        }else if(N <= 0.7){
            labirinto = new Sala(labirinto, sala2, inimigo);
        }else if(N <= 0.8){
            labirinto = new Sala(sala3, labirinto, inimigo);
        }else if(N <= 0.9){
            labirinto = new Sala(labirinto, sala3, inimigo);
        }else if(N <= 1.0){
            labirinto = new Sala(labirinto, labirinto, inimigo);
        }


        return labirinto;
    }

    public static Labirinto criaCaminho(){

        double N = Math.random();

        if(N < 0.5){
            return new Abismo();
        }else{
            return new Saida();
        }

    }

    public static void cria_E_Executa_Labirinto(int elemento, int construcao_do_personagem){
        Personagem[] personagem =  new Personagem[3];
        Personagem[] inimigo = new Inimigo[3];
        Fabrica_De_Personagem_Aleatorio f = null;
        Fabrica_De_Jogo fabrica_de_jogo;


        if(elemento == 0) {

            if(construcao_do_personagem == 0) {
                f = Fabrica_Simples_De_Personagem_Aleatorio.getInstance();
            }else if(construcao_do_personagem == 1){
                f = Fabrica_Avancada_De_Personagem_Aleatorio.getInstance();
            }

            fabrica_de_jogo = Fabrica_De_Jogo_Medieval.getInstance();

            if(f != null) {
                personagem[0] = f.createPersonagem(null, "Atreus", fabrica_de_jogo);
                personagem[1] = f.createPersonagem(null, "Ezio", fabrica_de_jogo);
                personagem[2] = f.createPersonagem(null, "Merida", fabrica_de_jogo);

                inimigo[0] = f.createPersonagem(personagem[0], "Ezio", fabrica_de_jogo);
                inimigo[1] = f.createPersonagem(personagem[1], "Link", fabrica_de_jogo);
                inimigo[2] = f.createPersonagem(personagem[2], "Atreus", fabrica_de_jogo);
            }


        }else if(elemento == 1){

            if(construcao_do_personagem == 0) {
                f = Fabrica_Simples_De_Personagem_Aleatorio.getInstance();
            }else if(construcao_do_personagem == 1){
                f = Fabrica_Avancada_De_Personagem_Aleatorio.getInstance();
            }

            fabrica_de_jogo = Fabrica_De_Jogo_Futurista.getInstance();

            if(f != null) {
                personagem[0] = f.createPersonagem(null, "Eva", fabrica_de_jogo);
                personagem[1] = f.createPersonagem(null, "Clank", fabrica_de_jogo);
                personagem[2] = f.createPersonagem(null, "BB-8", fabrica_de_jogo);

                inimigo[0] = f.createPersonagem(personagem[0], "Clank", fabrica_de_jogo);
                inimigo[1] = f.createPersonagem(personagem[1], "Bumblebee", fabrica_de_jogo);
                inimigo[2] = f.createPersonagem(personagem[2], "Eva", fabrica_de_jogo);
            }
        }

        Labirinto labirinto_1 = criaLabirinto(inimigo[0]);
        Labirinto labirinto_2 = criaLabirinto(inimigo[1]);
        Labirinto labirinto_3 = criaLabirinto(inimigo[2]);

        Thread t1 = new Thread(new Jogo_Labirinto(labirinto_1, personagem[0]));
        Thread t2 = new Thread(new Jogo_Labirinto(labirinto_2, personagem[1]));
        Thread t3 = new Thread(new Jogo_Labirinto(labirinto_3, personagem[2]));

        t1.start();
        t2.start();
        t3.start();
    }

}
