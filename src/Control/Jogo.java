package Control;
import Control.Command.Control.Joystick;
import Control.Command.Simple_Factory.Fabrica_De_Joystick;
import Control.Jogo_Tematico.Jogo_Futurista;
import Control.Jogo_Tematico.Jogo_Medieval;
import Model.Composite.Simple_Factory.Fabrica_Do_Jogo_De_Labirinto;
import Model.Factory.Abstract_Factory.Abstract_Factory.Fabrica_De_Jogo;
import Model.Factory.Factory_Method.Concrete_Creators__Simple_Factorys.Fabrica_Avancada_De_Personagem_Aleatorio;
import Model.Factory.Factory_Method.Concrete_Creators__Simple_Factorys.Fabrica_Simples_De_Personagem_Aleatorio;
import Model.Factory.Factory_Method.Creator.Fabrica_De_Personagem_Aleatorio;
import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;
import View.Audio;
import View.Desenho;
import View.Opcao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Jogo extends JFrame{
    private Desenho desenho;
    private static Personagem personagem;
    private static Personagem[] inimigo = new Inimigo[3];
    private Fabrica_De_Personagem_Aleatorio f;
    private int construcao_do_personagem;

    public Jogo(int construcao_do_personagem){
        this.construcao_do_personagem = construcao_do_personagem;
    }
    public void fabrica_de_personagem_aleatorio(){
        if(construcao_do_personagem == 0) {
            f = Fabrica_Simples_De_Personagem_Aleatorio.getInstance();
        }else if(construcao_do_personagem == 1){
            f = Fabrica_Avancada_De_Personagem_Aleatorio.getInstance();
        }
    }
    public void fabrica_tematica(Fabrica_De_Jogo fabrica_de_jogo, String[] nome){
            personagem = f.createPersonagem(null, nome[0], fabrica_de_jogo);
            inimigo[0] = f.createPersonagem(personagem, nome[1], fabrica_de_jogo);
            inimigo[1] = f.createPersonagem(personagem, nome[2], fabrica_de_jogo);
            inimigo[2] =f.createPersonagem(personagem, nome[3], fabrica_de_jogo);
    }
    public void configs(){

        desenho = new Desenho(personagem, inimigo);
        Joystick joystick = Fabrica_De_Joystick.criarJoystick(personagem, inimigo);
        KeyListener listener = new MyKeyListener(personagem, inimigo, joystick);
        addKeyListener(listener);
        setFocusable(true); //So that the JPanel object receives the keyboard notifications it is necessary to include the instruction setFocusable(true), which allows KeyboardExample to receive the focus.

        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(0, 0, 1500, 800);
        setVisible(true);
    }
    public void paint(Graphics g) {
        super.paint(g); //The call to "super.paint(g)", cleans the screen
        add(desenho.desenhar());

    }
    public static void iniciar_jogo() throws InterruptedException{
        Jogo jogo = null;
        int result;
        result = Opcao.escolha_do_jogo();

        if(result ==0 ) {

            result = Opcao.tema_do_jogo();

            if (result == 0) {

                result = Opcao.construcao_do_personagem();

                if(result == 0) {
                    jogo = new Jogo_Medieval(0);
                }else if(result  == 1){
                    jogo = new Jogo_Medieval(1);
                }
            } else if (result == 1) {

                result = Opcao.construcao_do_personagem();

                if(result == 0) {
                    jogo = new Jogo_Futurista(0);
                }else if(result  == 1){
                    jogo = new Jogo_Futurista(1);
                }

            }


            if (jogo != null) {

                while (true) {

                    if (personagem instanceof PersonagemPrincipal) {
                        ((PersonagemPrincipal) personagem).notifyObservers();
                    }

                    jogo.repaint();

                    if(personagem.getLife() == 0){
                        Audio.c.get(0).stop();
                        Audio.playSound("src/View/Audios/audio_morte.wav");
                        jogo.repaint();
                        Opcao.fim_de_jogo();

                    }

                    if (inimigo[0].getLife() == 0 && inimigo[1].getLife() == 0 && inimigo[2].getLife() == 0) {
                        Audio.c.get(0).stop();
                        Audio.playSound("src/View/Audios/audio_vitoria.wav");
                        jogo.repaint();
                        Opcao.jogo_ganho();
                    }

                    Thread.sleep(50);

                }
            }


        }else if(result == 1){

            result = Opcao.tema_do_jogo();

            if(result == 0) {
                result = Opcao.construcao_do_personagem();
                if(result == 0){
                    Fabrica_Do_Jogo_De_Labirinto.cria_E_Executa_Labirinto(0, 0);
                }else if(result == 1){
                    Fabrica_Do_Jogo_De_Labirinto.cria_E_Executa_Labirinto(0, 1);
                }
            }else if(result == 1){
                result = Opcao.construcao_do_personagem();
                if(result == 0){
                    Fabrica_Do_Jogo_De_Labirinto.cria_E_Executa_Labirinto(1, 0);
                }else if(result == 1){
                    Fabrica_Do_Jogo_De_Labirinto.cria_E_Executa_Labirinto(1, 1);
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException{

        iniciar_jogo();

    }


}