
package Model.Strategy.Concrete_Strategy_2_Corrida;
import Model.Observer.Observer_Inimigo.Inimigo;
import Model.Observer.Subject_PersonagemPrincial.PersonagemPrincipal;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_2_Corrida.Corrida;

public class Normal extends Corrida {

    public Normal(Personagem personagem) {
        super(personagem);
        if(personagem instanceof PersonagemPrincipal){
            setMove(20);
        }else if(personagem instanceof Inimigo){
            setMove(3);
        }
    }

    public void correrEsquerda(){
       personagem.setCoordenada_x(personagem.getCoordenada_x()-getMove());
    }

    public void correrDireita(){personagem.setCoordenada_x(personagem.getCoordenada_x()+getMove());
    }

    public void correrBaixo() {personagem.setCoordenada_y(personagem.getCoordenada_y()+getMove());
    }

    public void correrCima() {
        personagem.setCoordenada_y(personagem.getCoordenada_y()-getMove());
    }

}
