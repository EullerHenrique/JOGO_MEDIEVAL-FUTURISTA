package Model.Observer.Observer_Inimigo;

import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;

public abstract class Inimigo extends Personagem {

    Personagem personagemPrincipal;

    public Inimigo(Personagem personagemPrincipal, String nome) {
        super(nome);
        this.personagemPrincipal = personagemPrincipal;
        if(this.personagemPrincipal instanceof PersonagemPrincipal) {
            ((PersonagemPrincipal) this.personagemPrincipal).registerObserver(this);
        }
    }

    public void update(){

        int moveInicial = getCorrida().getMove();
        getViewPersonagem().DisplayProcura(personagemPrincipal);

            //Se a distância entre o atacante e o atacado for igual a i, o atacante irá iniciar a fase de aproximação,
            //ou seja, o atacante começará a se mover de um 1 em 1.
            //Ex: Move do atacante = 5
            //i = 1,2,3,4
            //Coordenada x do atacante = 50
            //Coordenada x do atacado = 46
            //Como 50 - 46 = 4,
            //o move do atacante recebe o valor 1
            for (int i = 1; i <= getCorrida().getMove() - 1; i++) {

                if (Math.abs(getCoordenada_x() - personagemPrincipal.getCoordenada_x()) == i) {
                    getCorrida().setMove(1);
                }

            }

            if (getCoordenada_x() > personagemPrincipal.getCoordenada_x()) {
               correr("Esquerda");
            } else if (getCoordenada_x() < personagemPrincipal.getCoordenada_x()) {
                correr("Direita");
            } else if (getCoordenada_x() == personagemPrincipal.getCoordenada_x()) { //Deslocamento padrão: 1
                getCorrida().setMove(moveInicial);
            }

            for (int i = 1; i <= getCorrida().getMove() - 1; i++) {


                if (Math.abs(getCoordenada_y() - personagemPrincipal.getCoordenada_y()) == i) {
                    getCorrida().setMove(1);
                }

            }

            if (getCoordenada_y() > personagemPrincipal.getCoordenada_y()) {
               correr("Cima");
            } else if (getCoordenada_y() < personagemPrincipal.getCoordenada_y()) {
                correr("Baixo");
            } else if (getCoordenada_y() == personagemPrincipal.getCoordenada_y()) { //Deslocamento padrão: 1
               getCorrida().setMove(moveInicial);
            }

        if (getCoordenada_x() == personagemPrincipal.getCoordenada_x() && getCoordenada_y() == personagemPrincipal.getCoordenada_y()) {

            getViewPersonagem().DisplayEncontro(personagemPrincipal);
            atacar(personagemPrincipal);

        }
    }





}
