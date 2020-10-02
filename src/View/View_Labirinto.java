package View;


import Model.Composite.Component.Labirinto;
import Model.Strategy.Context__Personagem.Personagem;

public class View_Labirinto {

    public static void sensores(Personagem personagem, Personagem inimigo, Labirinto caminho_1, Labirinto caminho_2){
        System.out.println("\n\nOs sensores de movimento detectaram que um personagem acabou entrar na sala! \n" +
                "Essa sala possui um inimigo e dois caminhos\n\n" +
                "Informações do(a) personagem: \n" + " Nome: "+ personagem.getNome() +"\n Life: " + personagem.getLife()+"\n"+ "Tipo: "+personagem.getClass().getSimpleName() + "\n"+ "Estado: "+ personagem.getPersonagemState().getClass().getSimpleName() + "\n"+
                "Informações do(a) inimigo: \n Nome: " + inimigo.getNome() + "\n Life: "+ inimigo.getLife()+"\n"+ "Tipo: "+inimigo.getClass().getSimpleName() + "\n"+ "Estado: "+ inimigo.getPersonagemState().getClass().getSimpleName() + "\n\n"+
                "Informações dos caminhos: \n " +
                "Caminho 1: "+ caminho_1.getClass().getSimpleName() +
                "\n Caminho 2: "+ caminho_2.getClass().getSimpleName()+"\n\n");
    }

    public static void personagem_matou(Personagem personagem, Personagem inimigo){
        System.out.println("O(a) personagem "+personagem.getNome()+" matou o(a) inimigo(a) "+inimigo.getNome());
    }

    public static void personagem_fugiu(Personagem personagem, Personagem inimigo){
        System.out.println("O(a) personagem "+personagem.getNome()+" fugiu do(a) inimigo(a) "+inimigo.getNome());

    }

    public static void inimigo_matou(Personagem personagem, Personagem inimigo){
        System.out.println("O(a) inimigo(a) "+inimigo.getNome()+" matou o(a) personagem "+personagem.getNome());
    }

    public static void indo_em_direcao(Personagem personagem, Labirinto caminho){
        System.out.println("O(a) personagem " + personagem.getNome() + " está indo em direção à (ao) " + caminho.getClass().getSimpleName());
    }

    public static void abismo(Personagem personagem){
        System.out.println("O(a) personagem "+personagem.getNome()+" caiu no abismo e morreu!!");
    }

    public static void saida(Personagem personagem){
        System.out.println("O(a) personagem "+personagem.getNome()+" saiu do labirinto!!!!");
    }
}
