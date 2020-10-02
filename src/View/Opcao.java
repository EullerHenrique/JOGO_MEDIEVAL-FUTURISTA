package View;

import javax.swing.*;

public class Opcao {

    public static int escolha_do_jogo(){
        Object[] options = {"Jogo Temático", "Jogo De Labirinto"};

        int result = JOptionPane.showOptionDialog(null, "Olá!\n\n"+
                        "Voçê deseja jogar um jogo temático ou um executar um jogo de labirinto?\n\n",
                "Jogo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                null);

        return result;
    }
    public static int tema_do_jogo(){
        Object[] options = {"Medieval", "Futurista"};;
        int result = JOptionPane.showOptionDialog(null, "Olá!\n\n" +
                        "Qual será o tema do jogo??\n\n",
                "Jogo Temático", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                null);
        return result;
    }
    public static int construcao_do_personagem() {
        Object[] options = {"Personagem Simples", "Personagem Avançado"};
        int result = JOptionPane.showOptionDialog(null, "Olá!\n\n" +
                        "Voçê deseja construir um personagem simples ou avançado?\n\n",
                "Construção do personagem", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                null);
        return result;
    }

    public static void jogo_ganho(){
        Object[] options = {"Encerrar Jogo"};
        int result = JOptionPane.showOptionDialog(null, "Parabéns! Voçê ganhou o jogo!!!!",
                "Parabéns!!! ",  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                null);
        if(result == 0){
            System.exit(0);
        }
    }

    public static void fim_de_jogo(){
        Object[] options = {"Encerrar Jogo"};
        int result = JOptionPane.showOptionDialog(null, "Game Over! Voçê perdeu o jogo!!!!",
                "Game Over!!! ",  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                null);
        if(result == 0) {
            System.exit(0);
        }
    }
}
