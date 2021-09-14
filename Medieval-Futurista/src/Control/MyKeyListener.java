package Control;


import Control.Command.Control.Joystick;
import Model.Observer.Subject_PersonagemPrincial.Product_Arqueiro.Arqueiro;
import Model.Observer.Subject_PersonagemPrincial.Product_Robo.Robo;
import Model.Strategy.Context__Personagem.Personagem;
import View.Audio;

import java.awt.event.KeyEvent;

public class MyKeyListener implements java.awt.event.KeyListener {
    private static Personagem personagem;
    private static Personagem[] inimigo;
    private static Joystick joystick;

    public MyKeyListener(Personagem p, Personagem[] i, Joystick j) {
        personagem = p;
        inimigo = i;
        joystick = j;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                joystick.press(0);

                audio_tematico("src/View/Audios/audio_move_medieval.wav", "src/View/Audios/audio_move_futurista.wav");
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                joystick.press(1);
                audio_tematico("src/View/Audios/audio_move_medieval.wav", "src/View/Audios/audio_move_futurista.wav");
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                joystick.press(2);
                audio_tematico("src/View/Audios/audio_move_medieval.wav", "src/View/Audios/audio_move_futurista.wav");
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                joystick.press(3);

                audio_tematico("src/View/Audios/audio_move_medieval.wav", "src/View/Audios/audio_move_futurista.wav");
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                atacar_inimigo(4, 7, "src/View/Audios/audio_ataque_medieval.wav", "src/View/Audios/audio_ataque_futurista.wav");

            }

            if (e.getKeyCode() == KeyEvent.VK_L) {
                joystick.pressMacroL();
                audio_L_R();
            }

            if (e.getKeyCode() == KeyEvent.VK_R) {
                joystick.pressMacroR();
                audio_L_R();
            }

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                atacar_inimigo(7, 10, "src/View/Audios/audio_magia_medieval.wav", "src/View/Audios/audio_magia_futurista.wav");

            }
        }


    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
    }


    public void audio_tematico(String medieval, String futurista) {
        if (personagem instanceof Arqueiro) {
            Audio.playSound(medieval);
        } else if (personagem instanceof Robo) {
            Audio.playSound(futurista);
        }
    }

    public void audio_L_R() {
        Audio.playSound("src/View/Audios/audio_L_R.wav");
    }

    public void atacar_inimigo(int j1, int j2, String medieval, String futurista) {

        for (int i = 0, j = j1; i < inimigo.length && j < j2; i++, j++) {

            if (inimigo[i].getLife() > 0 && personagem.getLife() > 0) {

                if (
                        (Math.abs(personagem.getCoordenada_x() - inimigo[i].getCoordenada_x()) <= 150 && personagem.getCoordenada_x() >= 0)
                                && (Math.abs(personagem.getCoordenada_y() - inimigo[i].getCoordenada_y()) <= 150 && personagem.getCoordenada_y() >= 0)
                ) {
                    joystick.press(j);
                    audio_tematico(medieval, futurista);
                }
            }
        }

    }

}

