package Model.Strategy.Strategy_2_Corrida;

import Model.Strategy.Context__Personagem.Personagem;

public abstract class Corrida {
    protected Personagem personagem;
    private int move;

    public Corrida(Personagem personagem) {
        this.personagem = personagem;
    }

    public int getMove() {
        return move;
    }
    public void setMove(int move) {
        this.move = move;
    }


    public boolean validar(){
        if(personagem.getLife() > 0) {
            return true;
        }else{
            personagem.getViewPersonagem().DisplayErroMorteCorrida();
            return false;
        }
    }

    public void correr(String direcao){


        if(validar()){

            System.out.println("\n========================================================================================================================\n");
            personagem.getViewPersonagem().DisplayPosicao();

            switch (direcao) {
                case "Esquerda" -> {
                        correrEsquerda();
                    }
                case "Direita" -> {
                        correrDireita();
                    }
                case "Cima" -> {
                        correrCima();
                }
                case "Baixo" -> {
                        correrBaixo();
                    }
                }

                personagem.getViewPersonagem().DisplayCorrida(direcao, getMove());
                personagem.getViewPersonagem().DisplayPosicao();
                System.out.println("\n========================================================================================================================\n");

        }


    }

    public abstract void correrEsquerda();
    public abstract void correrDireita();
    public abstract void correrCima();
    public abstract void correrBaixo();


}
